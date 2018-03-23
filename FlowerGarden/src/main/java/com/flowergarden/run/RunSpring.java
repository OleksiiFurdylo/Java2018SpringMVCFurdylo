package com.flowergarden.run;

import com.flowergarden.configuration.ApplicationConfiguration;
import com.flowergarden.services.BouquetService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by OleksiiF on 20.03.2018.
 */
public class RunSpring {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        BouquetService bouquetService = ctx.getBean("bouquetService", BouquetService.class);
        System.out.println(bouquetService.getBouqetPriceService(1));

    }
}

