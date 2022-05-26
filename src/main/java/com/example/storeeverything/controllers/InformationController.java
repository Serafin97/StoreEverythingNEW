package com.example.storeeverything.controllers;

import com.example.storeeverything.models.Information;
import com.example.storeeverything.repositories.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InformationController {

    @Autowired
    private InformationRepository informationRepository;

    @GetMapping({"/informations/sharedinformations"})
    public String sharedInformations(Model model){

        model.addAttribute("informations", this.informationRepository.findAll());
        return "/informations/sharedinformations";
    }

/*    @GetMapping({"/informations/myinformations"})
    public String myInformations(Model model){
        model.addAttribute("userList", this.informationRepository.findAll());
        return "/informations/myinformations";
    }*/
}
