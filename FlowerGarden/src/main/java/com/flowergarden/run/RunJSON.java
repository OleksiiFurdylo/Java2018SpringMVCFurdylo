package com.flowergarden.run;

import com.flowergarden.configuration.ApplicationConfiguration;
import com.flowergarden.services.BouquetJSONService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by OleksiiF on 27.03.2018.
 */
public class RunJSON {
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        BouquetJSONService bouquetJSONService = ctx.getBean("bouquetJSONService", BouquetJSONService.class);
        bouquetJSONService.saveBouquetToFile(1);

        System.out.println(bouquetJSONService.readBouquetFromFile(1).getName()+"<- from json");



    }
}
