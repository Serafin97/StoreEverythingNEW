package com.example.storeeverything.controllers;

import com.example.storeeverything.models.Information;
import com.example.storeeverything.repositories.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class InformationController {

    @Autowired
    private InformationRepository informationRepository;

    @GetMapping({"/informations/sharedinformations"})
    public String sharedInformations(Model model){

        model.addAttribute("informations", this.informationRepository.findAll());


        return "/informations/sharedinformations";
    }

    @GetMapping({"/informations/sharedinformations/{sort}"})
    public String myInformations(@PathVariable int sort, Model model){
        System.out.println(sort);
        if(sort == 1) {
            model.addAttribute("informations", informationRepository.findAll(PageRequest.of(0, 30, Sort.by(Sort.Direction.ASC, "addDate"))));
        } else if (sort == 2) {
            model.addAttribute("informations", informationRepository.findAll(PageRequest.of(0, 30, Sort.by(Sort.Direction.DESC, "addDate"))));
        } else if (sort == 3) {
            model.addAttribute("informations", informationRepository.findAll(PageRequest.of(0, 30, Sort.by(Sort.Direction.ASC, "category"))));
        } else if (sort == 5) {
            model.addAttribute("informations", informationRepository.findAll(PageRequest.of(0, 30, Sort.by(Sort.Direction.DESC, "addDate"))));
        }

        return "/informations/sharedinformations";
    }
}
