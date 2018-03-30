package com.flowergarden.services;

import com.flowergarden.DAO.impl.BouquetDAOimpl;
import com.flowergarden.DAO.impl.BouquetJSONDAOimpl;
import com.flowergarden.DAO.impl.FlowerDAOimpl;
import com.flowergarden.flowers.BouquetWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by OleksiiF on 27.03.2018.
 */
@Service
public class BouquetJSONService {

    private FlowerDAOimpl flowerDAOimpl;
    private BouquetDAOimpl bouquetDAOimpl;
    private BouquetWrapper bouquetWrapper;
    private BouquetJSONDAOimpl bouquetJSONDAOimpl;

    @Autowired
    public void setBouquetJSONDAOimpl(BouquetJSONDAOimpl bouquetJSONDAOimpl) {
        this.bouquetJSONDAOimpl = bouquetJSONDAOimpl;
    }

    @Autowired
    public void setBouquetWrapper(BouquetWrapper bouquetWrapper) {
        this.bouquetWrapper = bouquetWrapper;
    }

    @Autowired
    public void setBouquetDAOimpl(BouquetDAOimpl bouquetDAOimpl) {
        this.bouquetDAOimpl = bouquetDAOimpl;
    }

    @Autowired
    public void setFlowerDAOimpl(FlowerDAOimpl flowerDAOimpl) {
        this.flowerDAOimpl = flowerDAOimpl;
    }


    public void saveBouquetService(int bouquetId){
        bouquetWrapper.setName(bouquetDAOimpl.getBouquetName(bouquetId));
        bouquetWrapper.setAssemblyPrice(bouquetDAOimpl.getAssemblePriceForBouqet(bouquetId));
        bouquetWrapper.setFlowerWrappers(flowerDAOimpl.getFlowersInBouquet(bouquetId));
        bouquetWrapper.setId(bouquetId);
        bouquetDAOimpl.closeConnection();

        bouquetJSONDAOimpl.saveBouquetToFile(bouquetWrapper);
    }

    public BouquetWrapper readBouquetService(int bouquetId){
        return bouquetJSONDAOimpl.readBouquetFromFile(bouquetId);
    }

}
