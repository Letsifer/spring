package edu.altstu.service;

import edu.altstu.core.SweetPack;
import edu.altstu.core.Sweet;

/**
 *
 * @author Евгений
 */
public interface DBWorkService {

    SweetPack getSweetPack(Long id);
    
    Iterable<Sweet> getSweets();
    
    Sweet getOneSweet(Long id);
    
    SweetPack getSweetPack(String barcode);
    
    Iterable<SweetPack> getAllSweetPack();
    
    SweetPack createOrUpdatePack(SweetPack pack);
       
    void deletePack(Long id);
    
}
