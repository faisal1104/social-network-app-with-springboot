package com.example.springbootform.controller;

import com.example.springbootform.dto.UserDto;
import com.example.springbootform.model.Role;
import com.example.springbootform.model.User;
import com.example.springbootform.repository.RoleRepository;
import com.example.springbootform.repository.UserRepository;
import com.example.springbootform.service.RegService;
import com.example.springbootform.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/reg")
public class RegController {

    @Autowired
    private RegService regService;
    @Autowired
    private RoleRepository roleRepository;
    @GetMapping("/")
    public String add(Model m){
        m.addAttribute("userReg", new UserDto());
        return "reg";
    }


    @PostMapping("/save")
    public RedirectView save(@ModelAttribute("userReg") UserDto userDto){
        regService.saveUser(userDto);
        return new RedirectView("/login/");
    }
}
