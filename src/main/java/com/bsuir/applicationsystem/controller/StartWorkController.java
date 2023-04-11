package com.bsuir.applicationsystem.controller;

import com.bsuir.applicationsystem.entity.Applicants;
import com.bsuir.applicationsystem.entity.Role;
import com.bsuir.applicationsystem.entity.Roles;
import com.bsuir.applicationsystem.entity.User;
import com.bsuir.applicationsystem.reops.ApplicantJpaRepo;
import com.bsuir.applicationsystem.reops.UserJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class StartWorkController {

    private final ApplicantJpaRepo applicantJpaRepo;
    private final UserJpaRepo userJpaRepo;

    @GetMapping("/login")
    public String hello() {
        return "login";
    }

    @GetMapping("/registration")
    public String goToRegPage() {
        return "registration";
    }

    @PostMapping("/registration")
    public String saveNewUser(User user, Applicants applicants, Model model) {
        User username = userJpaRepo.findByLogin(user.getLogin());

        if (username != null) {
            model.addAttribute("message", "User already exists");
            return "registration";
        }
        user.setRoles(new Roles(2L,Role.USER,"USER"));
        applicants.setUser(user);
        applicantJpaRepo.save(applicants);
        System.out.println(applicants);


        return "redirect:/auth/login";
    }
}
