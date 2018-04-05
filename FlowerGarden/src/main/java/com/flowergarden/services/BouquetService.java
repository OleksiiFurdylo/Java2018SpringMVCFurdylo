package com.flowergarden.services;

import com.flowergarden.DAO.impl.BouquetDAOimpl;
import com.flowergarden.DAO.impl.FlowerDAOimpl;
import com.flowergarden.flowers.FlowerWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by OleksiiF on 13.03.2018.
 */
@Service
public class BouquetService {

    private FlowerDAOimpl flowerDAOimpl;
    private BouquetDAOimpl bouquetDAOimpl;

    @Autowired
    public void setFlowerDAOimpl(FlowerDAOimpl flowerDAOimpl) {
        this.flowerDAOimpl = flowerDAOimpl;
    }

    @Autowired
    public void setBouquetDAOimpl(BouquetDAOimpl bouquetDAOimpl) {
        this.bouquetDAOimpl = bouquetDAOimpl;
    }

    public float getBouqetPriceService(int bouqetId){
        float priceOfFlowersTogeather = 0.0f;

        ArrayList<Float> flowerPrices = flowerDAOimpl.getFlowerPricesForBouqet(bouqetId);
        for (Float flowerPrice: flowerPrices){
            priceOfFlowersTogeather += flowerPrice;
        }

        float assemblePrice = bouquetDAOimpl.getAssemblePriceForBouqet(bouqetId);

        //flowerDAOimpl.closeConnection();
        //bouquetDAOimpl.closeConnection();

        return priceOfFlowersTogeather + assemblePrice;
    }
}