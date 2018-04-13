package com.flowergarden.controllers;

import com.flowergarden.flowers.FlowerWrapper;
import com.flowergarden.services.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by OleksiiF on 13.04.2018.
 */
@Controller
public class FlowerController {

    @Autowired
    FlowerService flowerService;

    @RequestMapping("/flower/{id}")
    public String getFlower(@PathVariable("id") int flowerId, Model model){
        model.addAttribute("flower", flowerService.getFlower(flowerId));
        return "flower";
    }

    @RequestMapping("/flower/json/{id}")
    public @ResponseBody FlowerWrapper getFlowersInBouquetJson(@PathVariable("id") int flowerId){
        return flowerService.getFlower(flowerId);
    }
}
