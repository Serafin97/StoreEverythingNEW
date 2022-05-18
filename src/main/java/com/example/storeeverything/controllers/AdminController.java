package com.example.storeeverything.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @GetMapping({"/adminPanel/userlist"})
    public String userlist(){
        return "adminpanel/userlist";
    }
}
