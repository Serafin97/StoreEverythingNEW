package com.example.storeeverything.controllers;

import com.example.storeeverything.models.Information;
import com.example.storeeverything.repositories.InformationRepository;
import com.example.storeeverything.security.IAuthenticationFacade;
import com.example.storeeverything.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

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
    public String sharedInformationsSort(@PathVariable int sort, Model model){
        System.out.println(sort);
        if(sort == 1) {
            model.addAttribute("informations", informationRepository.findAll(PageRequest.of(0, 30, Sort.by(Sort.Direction.ASC, "category"))));
        } else if (sort == 2) {
            model.addAttribute("informations", informationRepository.findAll(PageRequest.of(0, 30, Sort.by(Sort.Direction.DESC, "category"))));
        } else if (sort == 4) {
            model.addAttribute("informations", informationRepository.findAll(PageRequest.of(0, 30, Sort.by(Sort.Direction.ASC, "addDate"))));
        } else if (sort == 5) {
            model.addAttribute("informations", informationRepository.findAll(PageRequest.of(0, 30, Sort.by(Sort.Direction.DESC, "addDate"))));
        }

        return "/informations/sharedinformations";
    }

    @GetMapping({"/informations/myinformations"})
    public String myInformations(Model model, HttpServletRequest request){

        model.addAttribute("informations", this.informationRepository.findAll());
        model.addAttribute("loggeduser", request.getUserPrincipal().getName());

        return "/informations/myinformations";
    }

    @GetMapping({"/informations/myinformations/{sort}"})
    public String myInformationsSort(@PathVariable int sort, Model model){
        System.out.println(sort);
        if(sort == 1) {
            model.addAttribute("informations", informationRepository.findAll(PageRequest.of(0, 30, Sort.by(Sort.Direction.ASC, "category"))));
        } else if (sort == 2) {
            model.addAttribute("informations", informationRepository.findAll(PageRequest.of(0, 30, Sort.by(Sort.Direction.DESC, "category"))));
        } else if (sort == 4) {
            model.addAttribute("informations", informationRepository.findAll(PageRequest.of(0, 30, Sort.by(Sort.Direction.ASC, "addDate"))));
        } else if (sort == 5) {
            model.addAttribute("informations", informationRepository.findAll(PageRequest.of(0, 30, Sort.by(Sort.Direction.DESC, "addDate"))));
        }

        return "/informations/myinformations";
    }


    @GetMapping({"/informations/choseninformation/{id}"})
    public String chosenInformation(@PathVariable Long id, Model model, HttpServletRequest request){

        model.addAttribute("information", this.informationRepository.getById(id));
        model.addAttribute("link", "http://localhost:8080/informations/choseninformation/" + id);
        model.addAttribute("loggeduser", request.getUserPrincipal().getName());

        return "/informations/choseninformation";
    }
}
