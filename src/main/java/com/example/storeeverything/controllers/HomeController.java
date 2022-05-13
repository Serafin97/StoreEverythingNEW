package com.example.storeeverything.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping({"/index", "/home", "","/", "/index.html"})
    public String homeSite(){
        return "index";
    }

}
