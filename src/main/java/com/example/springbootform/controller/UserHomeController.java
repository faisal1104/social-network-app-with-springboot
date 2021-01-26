package com.example.springbootform.controller;

import com.example.springbootform.dto.UserDto;
import com.example.springbootform.model.Status;
import com.example.springbootform.model.User;
import com.example.springbootform.repository.LocationRepository;
import com.example.springbootform.repository.StatusRepo;
import com.example.springbootform.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserHomeController {


    private final StatusRepo statusRepo;
    private final LocationRepository locationRepository;
    private final UserRepository userRepository;

    public UserHomeController(StatusRepo statusRepo, LocationRepository locationRepository, UserRepository userRepository) {
        this.statusRepo = statusRepo;
        this.locationRepository = locationRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/home")
    public String getHome(Model m){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        m.addAttribute("userDto", user);
      //  System.out.println(user.getStatus());
        return "user/home";
    }

    @GetMapping("/add-status")
    public String addStatus(Model model){

        model.addAttribute("status", new Status());
        model.addAttribute("locationList", locationRepository.findAll());
        List<String> privacyList = new ArrayList<>();
        privacyList.add("Public");
        privacyList.add("Private");
        model.addAttribute("privacyList", privacyList);
        return "user/addStatus";
    }

    @PostMapping("/post-status")
    public RedirectView post(@ModelAttribute("status") Status s){
//        statusRepo.save(s);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Status> statuses =  user.getStatus();
        System.out.println(statuses.get(0));
//        System.out.println(user.getStatus());
        userRepository.save(user);
        return new RedirectView("/user/home");
    }

}
