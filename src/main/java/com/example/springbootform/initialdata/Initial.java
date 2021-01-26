package com.example.springbootform.initialdata;

import com.example.springbootform.model.Location;
import com.example.springbootform.model.Role;
import com.example.springbootform.repository.LocationRepository;
import com.example.springbootform.repository.RoleRepository;
import com.example.springbootform.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class Initial implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final LocationRepository locationRepository;

    public Initial(RoleRepository roleRepository, LocationRepository locationRepository) {

        this.roleRepository = roleRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        Stream.of("ROLE_ADMIN", "ROLE_USER", "ROLE_HR")
                .filter(s -> !roleRepository.existsByAuthority(s))
                .map(Role::new)
                .map(roleRepository::save)
                .forEach(role -> {
                    System.out.println(role.getId());
                });

        Stream.of("Kuk", "Bor", "Raj")
                .map(Location::new)
                .map(locationRepository::save)
                .forEach(l -> {
                    System.out.println(l.getLocationName());
                });
    }
}