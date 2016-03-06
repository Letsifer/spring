package edu.altstu.service;

import edu.altstu.core.SweetPack;
import edu.altstu.core.Sweet;
import edu.altstu.repo.SweetPackRepository;
import edu.altstu.repo.SweetRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Евгений
 */
@Service
public class DBWorkServiceImpl implements DBWorkService{

    @Autowired
    private SweetPackRepository sweetPackRepository;
    
    @Autowired
    private SweetRepository sweetRepository;
    
    @Override
    public SweetPack getSweetPack(Long id) {
        return sweetPackRepository.getOne(id);
    }

    @Override
    public SweetPack getSweetPack(String barcode) {
        ArrayList<SweetPack> packs = (ArrayList<SweetPack>) getAllSweetPack();
        Optional<SweetPack> current = packs.stream().filter(item -> item.getBarcode().equals(barcode)).findFirst();
        return current.get();
    }

    @Override
    public Iterable<SweetPack> getAllSweetPack() {
        return sweetPackRepository.findAll();
    }

    @Override
    public Iterable<Sweet> getSweets() {
        return sweetRepository.findAll();
    }

    @Override
    public Sweet getOneSweet(Long id) {
        return sweetRepository.findOne(id);
    }
    
    

    @Override
    public SweetPack createOrUpdatePack(SweetPack pack) {
        return sweetPackRepository.save(pack);
    }

    @Override
    public void deletePack(Long id) {
        sweetPackRepository.delete(id);
    }
    
}
