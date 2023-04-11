package com.bsuir.applicationsystem.dao;

import com.bsuir.applicationsystem.reops.UserJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDao {

    private final UserJpaRepo userRepo;


    public UserDetails findUserByEmail(String email) {
/*        return users.stream().
                filter(x -> x.getUsername().equals(email)).findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("No user"))
                ;
    }*/
        return userRepo.findByLogin(email);
    }

}
