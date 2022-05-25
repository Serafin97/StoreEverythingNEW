package com.example.storeeverything.controllers;

import com.example.storeeverything.models.Information;
import com.example.storeeverything.models.User;
import com.example.storeeverything.repositories.InformationRepository;
import com.example.storeeverything.repositories.RoleRepository;
import com.example.storeeverything.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Controller
public class AdminController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private InformationRepository informationRepository;
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping({"/adminPanel/userlist"})
    public String userlist(Model model){
        model.addAttribute("userList", this.userRepository.findAll());
        return "adminPanel/userlist";
    }

    @GetMapping({"/adminPanel/userlist/delete/{id}"})
    public String deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);

/*        for (Information information: informationRepository.findAll()
             ) {
            if(Objects.equals(information.getUser().getId(), id)){
                informationRepository.deleteById(information.getId());
            }
        }*/
        return "redirect:/adminPanel/userlist";
    }

    @GetMapping({"/adminPanel/userlist/edit/{id}"})
    public String editUserForm(@PathVariable Long id, Model model){

        model.addAttribute("user", userRepository.findById(id).get());
        model.addAttribute("roles", roleRepository.findAll());

        return "/adminPanel/edituser";
    }

    @PostMapping({"/adminPanel/userlist/edit/{id}"})
    public String editUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model){

            if(result.hasErrors()){
            return "/adminPanel/edituser";
        }

        userRepository.save(user);
        model.addAttribute("user", user.getId());

        return "redirect:/adminPanel/userlist";
    }


    @GetMapping({"/adminPanel/adduser"})
    public String addUserForm(Model model){
        model.addAttribute("roles", this.roleRepository.findAll());
        model.addAttribute("newuser", new User());

        return "/adminPanel/adduser";
    }

    @PostMapping({"/adminPanel/adduser"})
    public String addUser(@Valid @ModelAttribute("newuser") User user, BindingResult result, Model model){
        if (result.hasErrors()){

            return "/adminPanel/adduser";
        }

        userRepository.save(user);
        model.addAttribute("newuser", user);
        return "redirect:/adminPanel/userlist";
    }

}
