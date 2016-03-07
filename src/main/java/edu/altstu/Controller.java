package edu.altstu;

import edu.altstu.core.SweetPack;
import edu.altstu.core.Sweet;
import edu.altstu.service.DBWorkService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Евгений
 */
@org.springframework.stereotype.Controller
public class Controller {

    protected final Log log = LogFactory.getLog(getClass());

    @Autowired
    private DBWorkService dBWorkService;

    @RequestMapping(method = RequestMethod.GET, value = "/packs")
    public String getAll(Model vars) {
        vars.addAttribute("packs", dBWorkService.getAllSweetPack());//.addAttribute("sweets", dBWorkService.getSweets());
        return "packs";
    }

    
    @RequestMapping(method = RequestMethod.GET, value = "/packs/{id}")
    public String getOne(@PathVariable Long id, Model vars) {
        if (id != 0) {
            SweetPack pack = dBWorkService.getSweetPack(id);
            vars.addAttribute("current", pack);
        } else {
            vars.addAttribute("current", new SweetPack());
        }
        vars.addAttribute("sweets", dBWorkService.getSweets());
        return "sweet";
    }
    
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/packs/{id}/ajax")
    public Object getOneAjax(@PathVariable Long id) {
        Map<String, Sweet> result = new HashMap<>();
        if (id != 0) {
            result.put("sweet", dBWorkService.getOneSweet(id));
        } else {
            result.put("sweet", null);
        }
        return result;
    }

//    @RequestMapping(method = RequestMethod.GET, value = "/sweet/{id}")
//    public String getOneSweet(@PathVariable Long id, Model vars) {
//        vars.addAttribute("currentSweet", dBWorkService.getOneSweet(id));
//        return "redirect:/sweet/" + id;
//    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/packs/{id}")
    public String deletePack(@PathVariable Long id) {
        dBWorkService.deletePack(id);
        return "redirect:/packs";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/packs/{id}")
    public String setInfo(@PathVariable Long id,
            @RequestParam(name = "barcode") String barcode,
            @RequestParam(name = "sweet") Long sweetId,
            @RequestParam(name = "number") Integer number,
            @RequestParam(name = "price") Double price,
            @RequestParam(name = "packing_date") String packingDate,
            @RequestParam(name = "expire_date") String expireDate
    ) {
        SweetPack pack;
        if (id == 0) {
            pack = new SweetPack();
        } else {
            pack = dBWorkService.getSweetPack(id);
        }

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if (barcode != null && !barcode.trim().isEmpty()) {
                pack.setBarcode(barcode);
            }
            if (sweetId != null) {
                pack.setSweet(dBWorkService.getOneSweet(sweetId));
            }
            if (price != null) {
                pack.setPrice(price);
            }
            if (number != null) {
                pack.setNumber(number);
            }
            if (packingDate != null && !packingDate.trim().isEmpty()) {
                Date date = dateFormat.parse(packingDate);
                pack.setPackingDate(date);
            } else {
                pack.setPackingDate(null);
            }
            if (expireDate != null && !expireDate.trim().isEmpty()) {
                Date date = dateFormat.parse(expireDate);
                pack.setExpireDate(date);
            } else {
                pack.setExpireDate(null);
            }

        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
        dBWorkService.createOrUpdatePack(pack);
        return "redirect:/packs";
    }
}
