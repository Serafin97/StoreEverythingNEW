package com.example.storeeverything.controllers;

import com.example.storeeverything.repositories.InformationRepository;
import com.example.storeeverything.repositories.RoleRepository;
import com.example.storeeverything.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class InformationController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private InformationRepository informationRepository;
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/informations/main")
    public String loginPage(){
        return "informations/main";
    }



}
