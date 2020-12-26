package com.example.springbootform.controller;


import com.example.springbootform.repository.StatusRepo;
import com.example.springbootform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.processing.Generated;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StatusRepo statusRepo;

    @GetMapping("/")
    public String all(Model m){
        m.addAttribute("allUser", userRepository.findAll());

        return "home";
    }

}
