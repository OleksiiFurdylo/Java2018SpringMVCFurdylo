package com.flowergarden.services;

import com.flowergarden.DAO.impl.FlowerDAOimpl;
import com.flowergarden.flowers.FlowerWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by OleksiiF on 13.04.2018.
 */
@Service
public class FlowerService {

    @Autowired
    FlowerDAOimpl flowerDAOimpl;

    public FlowerWrapper getFlower(int flowerId){
        return flowerDAOimpl.getFlower(flowerId);
    }
}
