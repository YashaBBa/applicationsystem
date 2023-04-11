package com.bsuir.applicationsystem.controller;

import com.bsuir.applicationsystem.entity.Faculty;
import com.bsuir.applicationsystem.entity.Specialty;
import com.bsuir.applicationsystem.entity.SpecialtyProperies;
import com.bsuir.applicationsystem.entity.User;
import com.bsuir.applicationsystem.reops.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/faculty")
@RequiredArgsConstructor
public class FacultyController {
    private final FacultyJpaRepo facultyJpaRepo;
    private final UserJpaRepo userRepo;

    private final SpecialityJpaRep specialityJpaRep;
    private final SpecialityPropJpaRepo specialityPropJpaRepo;
    @Autowired
    private StudyFormatJpaRepo studyFormatJpaRepo;
    @Autowired
    private ApplicationCompainJpaRepo applicationCompainJpaRepo;

    @GetMapping
    public String goToFacultyPage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = authentication.getName();
        User user = userRepo.findByLogin(login);
        model.addAttribute("userObject", user);
        List<Faculty> list = facultyJpaRepo.findAll();
        model.addAttribute("facultyList", list);


        return "mainpage";
    }

    @GetMapping("/{id}")
    public String getListOfSpeciality(@PathVariable Long id, Model model) {
        /*List<Specialty> specialties = specialityJpaRep.findByFacultyId(id);
        model.addAttribute("specialtiesList",specialties);*/
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = authentication.getName();
        User user = userRepo.findByLogin(login);
        model.addAttribute("compaingList", applicationCompainJpaRepo.findAll());
        model.addAttribute("studyFormatList", studyFormatJpaRepo.findAll());
        model.addAttribute("id", id);


        model.addAttribute("userObject", user);
        List<SpecialtyProperies> specialtyProperies = specialityPropJpaRepo.findAll();
        specialtyProperies = specialtyProperies.stream().filter(x -> x.getSpecialty().getFaculty().getId() == id).collect(Collectors.toList());
        model.addAttribute("specialtiesList", specialtyProperies);

        return "specialities";


    }

    @PostMapping("/delete/{id}")
    public String deleteFaculty(@PathVariable Long id) {
        facultyJpaRepo.deleteById(id);
        return "redirect:/api/faculty";
    }

}
