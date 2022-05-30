package com.example.storeeverything.controllers;

import com.example.storeeverything.models.Information;
import com.example.storeeverything.models.User;
import com.example.storeeverything.repositories.InformationRepository;
import com.example.storeeverything.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Controller
public class InformationController {

    @Autowired
    private InformationRepository informationRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping({"/informations/sharedinformations"})
    public String sharedInformations(Model model){

        model.addAttribute("informations", this.informationRepository.findAll());


        return "/informations/sharedinformations";
    }

    @GetMapping({"/informations/sharedinformations/{sort}"})
    public String sharedInformationsSort(@PathVariable int sort, Model model){

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
    public String myInformationsSort(@PathVariable int sort, Model model, HttpServletRequest request){
        model.addAttribute("loggeduser", request.getUserPrincipal().getName());
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

    @GetMapping({"/informations/choseninformation/remove/{id}"})
    public String chosenInformation(@PathVariable Long id){
        informationRepository.deleteById(id);

        return "redirect:/informations/myinformations";
    }

    @GetMapping({"/informations/addinformation"})
    public String addInformationForm(Model model){

        model.addAttribute("newinformation", new Information());

        return "/informations/addinformation";
    }

    @PostMapping({"/informations/addinformation"})
    public String addInformation(@Valid @ModelAttribute("newinformation") Information information, BindingResult result, Model model, HttpServletRequest request){
        if (result.hasErrors()){
            return "/informations/addinformation";
        }

        Date date = new Date();
        information.setAddDate(date);

        String username = request.getUserPrincipal().getName();
        User user = userRepository.findByUsername(username);
        information.setUser(user);

        informationRepository.save(information);
        model.addAttribute("newinformation", information);

        return "redirect:/informations/myinformations";
    }

    @GetMapping({"/informations/editinformation/{id}"})
    public String editInformationForm(@PathVariable Long id, Model model){

        model.addAttribute("information", informationRepository.findById(id).get());

        return "/informations/editinformation";
    }

    @PostMapping({"/informations/editinformation/{id}"})
    public String editInformation(@Valid @ModelAttribute("information") Information information, BindingResult result, Model model, HttpServletRequest request){

        if(result.hasErrors()){
            return "/informations/editinformation";
        }

        String username = request.getUserPrincipal().getName();
        User user = userRepository.findByUsername(username);
        information.setUser(user);

        informationRepository.save(information);
        model.addAttribute("information", information.getId());

        return "redirect:/informations/myinformations";
    }

}
