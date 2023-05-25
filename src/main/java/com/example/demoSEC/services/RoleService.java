package com.example.demoSEC.services;


import com.example.demoSEC.model.Role;
import com.example.demoSEC.repstry.RoleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepo roleRepo;

    public List<Role> findAll() {

        return roleRepo.findAll();
    }

    public Role findById(Long id) {

        return roleRepo.findById(id).orElse(null);
    }

    public Role findByName(String name) {

        return roleRepo.findByName(name);
    }

    public Role save(Role entity) {

        return roleRepo.save(entity);
    }
}

