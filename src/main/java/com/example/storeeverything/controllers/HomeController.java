package com.example.storeeverything.controllers;

import com.example.storeeverything.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping({"/index", "/home", "","/", "/index.html"})
    public String homeSite(){
        return "index";
    }


    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model){

        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

}
