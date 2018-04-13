package com.flowergarden.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by OleksiiF on 13.04.2018.
 */
@Controller
public class HelloController {
    String msg = "Hello world massage";

    @RequestMapping("/hello")
    public ModelAndView showMessage(@RequestParam(value = "name",
            required = false, defaultValue = "hello default name") String name) {
        System.out.println("in controller");

        ModelAndView mv = new ModelAndView("helloworld");
        mv.addObject("message", msg);
        mv.addObject("name", name);
        return mv;
    }

}
