package com.example.storeeverything.controllers;

import com.example.storeeverything.models.User;
import com.example.storeeverything.repositories.RoleRepository;
import com.example.storeeverything.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping({"/index", "/home", "","/", "/index.html"})
    public String homeSite(){
        return "index";
    }


    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping({"/register"})
    public String registerPage(Model model){

        model.addAttribute("newuser", new User());
        model.addAttribute("roles", roleRepository.findAll());
        return "register";
    }

    @PostMapping({"/register"})
    public String addUser(@Valid @ModelAttribute("newuser") User user, BindingResult result, Model model){
        if (result.hasErrors()){

            return "register";
        }
        userRepository.save(user);
        model.addAttribute("newuser", user/*userRepository.findAll()*/);


        return "redirect:/adminPanel/userlist";
    }

}
