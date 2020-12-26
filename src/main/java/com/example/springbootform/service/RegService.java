package com.example.springbootform.service;

import com.example.springbootform.dto.UserDto;
import com.example.springbootform.exception.ResourceNotFoundException;
import com.example.springbootform.model.Role;
import com.example.springbootform.model.User;
import com.example.springbootform.repository.RoleRepository;
import com.example.springbootform.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class RegService {

    private final PasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public RegService(PasswordEncoder bCryptPasswordEncoder,
                   UserRepository userRepository,
                   RoleRepository roleRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public void saveUser( UserDto userDto){

        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        List<Role> roleList = roleRepository.findAll();
        user.setRole(roleList.get(0));
        System.out.println(userRepository.existsByUsername(user.getUsername()));
        System.out.println(userRepository.existsByEmail(user.getEmail()));
        String passTemp = bCryptPasswordEncoder.encode(userDto.getPassword());
        if(( (userRepository.existsByUsername(user.getUsername())) || (userRepository.existsByEmail(user.getEmail())) )){
            throw new ResourceNotFoundException("Username and Email Alrady Exist.");
        }

        else {
            user.setPassword(passTemp);
            userRepository.save(user);
        }
    }
}
