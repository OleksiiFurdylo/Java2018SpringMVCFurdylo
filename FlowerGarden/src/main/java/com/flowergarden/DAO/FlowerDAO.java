package com.flowergarden.DAO;

import com.flowergarden.flowers.Flower;
import com.flowergarden.flowers.FlowerWrapper;
import com.flowergarden.flowers.GeneralFlower;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

/**
 * Created by OleksiiF on 13.03.2018.
 */
public interface FlowerDAO {

    ArrayList<FlowerWrapper> getAllFlowers();
    FlowerWrapper getFlower(int id);
    void updateFlower(FlowerWrapper flower);
    void deleteFlower(int id);
    void addFlower(Flower flower);
    void closeConnection();

    ArrayList<Float> getFlowerPricesForBouqet(int bouqetId) throws IOException;

}