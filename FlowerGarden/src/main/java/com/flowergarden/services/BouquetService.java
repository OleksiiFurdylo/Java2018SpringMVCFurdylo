package com.flowergarden.services;

import com.flowergarden.DAO.impl.BouquetDAOimpl;
import com.flowergarden.DAO.impl.FlowerDAOimpl;
import com.flowergarden.exceptions.FreshnessUnderZeroException;
import com.flowergarden.flowers.FlowerWrapper;
import com.flowergarden.properties.FreshnessInteger;
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

    public ArrayList<FlowerWrapper> getBouquetFlowers(int bouquetId) {
        return flowerDAOimpl.getFlowersInBouquet(bouquetId);
    }

    public void lowerFreshnessInBouquet(int bouquetId) throws FreshnessUnderZeroException {

        ArrayList<FlowerWrapper> flowers = flowerDAOimpl.getFlowersInBouquet(bouquetId);
        for (FlowerWrapper f: flowers) {
            if (f.getFreshness().getFreshness() == 0) {
                throw new FreshnessUnderZeroException("freshness of flower with id:"
                        + f.getId() +" exceeded its lowest limit and cant be lowered more");
            } else {
                f.setFreshness(new FreshnessInteger(f.getFreshness().getFreshness()-1));
                flowerDAOimpl.updateFlower(f);
            }
        }
    }
}