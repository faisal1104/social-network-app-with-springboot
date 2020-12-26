package com.example.springbootform.service;


import com.example.springbootform.exception.ResourceNotFoundException;
import com.example.springbootform.model.User;
import com.example.springbootform.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = (User) userRepository.findByUsername(username).orElseThrow(() ->
                new ResourceNotFoundException("User with this username does not exist"));
        return user;
    }
}