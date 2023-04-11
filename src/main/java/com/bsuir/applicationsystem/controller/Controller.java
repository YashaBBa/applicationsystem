package com.bsuir.applicationsystem.controller;

import com.bsuir.applicationsystem.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")

public class Controller {



    @GetMapping

    public ResponseEntity<String> sayHi() {


        return ResponseEntity.ok("HI");
    }

    @GetMapping("/greeting-ha-ha")
    public ResponseEntity<String> haha() {
        return ResponseEntity.ok("AHAHAHAHAHAHAHAHAH");
    }
}
