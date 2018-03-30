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
        bouquetJSONService.saveBouquetService(1);

        System.out.println(bouquetJSONService.readBouquetService(1).getName()+"<- bouquet from json");
        System.out.println(bouquetJSONService.readBouquetService(1).getAssemblyPrice()+"<ap");


    }
}
