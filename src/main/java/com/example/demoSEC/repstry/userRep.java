package com.example.demoSEC.repstry;


import com.example.demoSEC.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface userRep extends JpaRepository<AppUser,Long> {
    Optional<AppUser> findByUserName (String userName) ;
}
