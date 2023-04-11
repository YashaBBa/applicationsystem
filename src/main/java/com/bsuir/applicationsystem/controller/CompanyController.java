package com.bsuir.applicationsystem.controller;

import com.bsuir.applicationsystem.entity.Request;
import com.bsuir.applicationsystem.entity.SpecialtyProperies;
import com.bsuir.applicationsystem.reops.RequestJpaRepo;
import com.bsuir.applicationsystem.reops.SpecialityJpaRep;
import com.bsuir.applicationsystem.reops.SpecialityPropJpaRepo;
import com.bsuir.applicationsystem.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private SpecialityJpaRep specialityJpaRep;
    @Autowired
    private SpecialityPropJpaRepo specialityPropJpaRepo;

    @Autowired
    private RequestJpaRepo requestJpaRepo;

    @PostMapping("/end")
    public String finishCompany() {
        applicationService.applyAllApplicantsMyScoreAndPriority(specialityPropJpaRepo.findAll());
        return "redirect:/api/faculty";
    }

    @GetMapping("/requests")
    public String goToRequestListPage(Model model) {
        List<Request> requestList = new ArrayList<>();
        requestList = requestJpaRepo.findAll();
        model.addAttribute("requestList", requestList);
        return "requestsPage";


    }

}
