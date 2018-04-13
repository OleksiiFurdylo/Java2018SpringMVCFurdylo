package com.flowergarden.controllers;

import com.flowergarden.exceptions.FreshnessUnderZeroException;
import com.flowergarden.flowers.FlowerWrapper;
import com.flowergarden.services.BouquetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * Created by OleksiiF on 10.04.2018.
 */
@Controller
@RequestMapping("/bouquet/{id}")
public class BouquetController {

    @Autowired
    BouquetService bouquetService;

    @RequestMapping("/price")
    public ModelAndView getBouquetPrice(@PathVariable("id") int bouquetId){
        ModelAndView model = new ModelAndView("bouquet_price");
        Float price = bouquetService.getBouqetPriceService(bouquetId);
        model.addObject("bouquetId", price.toString());

        return model;
    }

    @RequestMapping("/flowers")
    public String getBouquetFlowers(@PathVariable("id") int bouquetId, Model model){
        model.addAttribute("flowers", bouquetService.getBouquetFlowers(bouquetId));
        return "bouquet_flowers";
    }

    @RequestMapping("/flowers/json")
    public @ResponseBody ArrayList<FlowerWrapper> getBouquetFlowersJson(@PathVariable("id") int bouquetId){
        return bouquetService.getBouquetFlowers(bouquetId);
    }

    @RequestMapping("/lower_freshness")
    public @ResponseBody String lowerBouquetFreshness(@PathVariable("id") int bouquetId){
        try {
            bouquetService.lowerFreshnessInBouquet(bouquetId);
        } catch (FreshnessUnderZeroException e) {
            return e.getMessage();
        }
        return "bouquet freshness lowered";
    }


}
