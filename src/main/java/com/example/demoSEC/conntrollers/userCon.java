package com.example.demoSEC.conntrollers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class userCon {

    private final com.example.demoSEC.services.UserServ UserServ;

    @GetMapping("")
    public ResponseEntity<?> findAll() {

        return ResponseEntity.ok(UserServ.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id ) {

        return ResponseEntity.ok(UserServ.findById(id));
    }
}
