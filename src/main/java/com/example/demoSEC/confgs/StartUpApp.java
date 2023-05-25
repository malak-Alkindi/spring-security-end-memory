package com.example.demoSEC.confgs;

import com.example.demoSEC.model.AppUser;
import com.example.demoSEC.model.Role;
import com.example.demoSEC.services.RoleService;
import com.example.demoSEC.services.UserServ;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;


@Component
    @RequiredArgsConstructor
    public class StartUpApp implements CommandLineRunner {


    private final UserServ userService;

    private final RoleService roleService;

    @Override
    public void run(String... args) throws Exception {


        if (roleService.findAll().isEmpty()) {
            roleService.save(new Role(null, "admin"));
            roleService.save(new Role(null, "user"));
            roleService.save(new Role(null, "employee"));
        }


        if (userService.findAll().isEmpty()) {

            Set<Role> adminRoles = new HashSet<>();
            adminRoles.add(roleService.findByName("admin"));

            Set<Role> userRoles = new HashSet<>();
            userRoles.add(roleService.findByName("user"));

            Set<Role>  empRoles = new HashSet<>();
            empRoles.add(roleService.findByName("employee"));

            userService.save(new AppUser(null, "Nour Shaheen", "nour", "123", adminRoles));

            userService.save(new AppUser(null, "Ali Mohamed", "ali", "123", userRoles));

            userService.save(new AppUser(null, "Ahmed Ebraheem", "ahmed", "123", empRoles));
        }

    }
}
