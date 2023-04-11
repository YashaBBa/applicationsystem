package com.bsuir.applicationsystem.controller;

import com.bsuir.applicationsystem.entity.*;
import com.bsuir.applicationsystem.reops.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/speciality")
public class SpecialytyController {
    @Autowired
    private SpecPropHasSubRepo repo;
    @Autowired
    private SpecialityPropJpaRepo specialityPropJpaRepo;
    @Autowired
    private SpecialityJpaRep specialityJpaRep;
    @Autowired
    private RequestJpaRepo requestJpaRepo;
    @Autowired
    private UserJpaRepo userJpaRepo;
    @Autowired
    private ApplicantJpaRepo applicantJpaRepo;

    @Autowired
    private StudyFormatJpaRepo studyFormatJpaRepo;
    @Autowired
    private ApplicationCompainJpaRepo applicationCompainJpaRepo;

    @GetMapping("{id}")
    public String goToInputSoreList(@PathVariable Integer id, Model model) {


        //List<SpecialtyHasSubjects> list = repo.findAllBySpecialtyProperies(id);
        List<SpecialtyHasSubjects> list = repo.findAllBySpecialtyProperies(id);
        model.addAttribute("subjectList", list);
        model.addAttribute("specialityId", id);

        return "sendApplicationPage";
    }

    @PostMapping("/sendRequest")
    public String sendRequest(Long specId,
                              Integer firstSubject,
                              Integer secondSubject,
                              Integer thirdSubject,
                              Integer midlScore,
                              Model model) {
        int score = firstSubject + secondSubject + thirdSubject + midlScore;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = authentication.getName();

        User user = userJpaRepo.findByLogin(login);
        Applicants applicants = applicantJpaRepo.findByUser(user);
        Specialty specialty = specialityJpaRep.getById(specId);
        Integer maxPriority = requestJpaRepo.findMaxPriorityByApplicant(applicants.getId());
        if (maxPriority == null) {
            maxPriority = 1;
        } else {
            maxPriority++;
        }
        Request request = new Request();
        request.setApplicants(applicants);
        request.setScore(score);
        request.setSpecialty(specialty);
        request.setPosition(maxPriority);
        request.setLook(1);
        GregorianCalendar calendar = (GregorianCalendar) GregorianCalendar.getInstance();
        Date date = calendar.getTime();
        request.setDate(new java.sql.Date(date.getTime()));
        requestJpaRepo.save(request);
        return "redirect:/api/faculty";


    }

    @PostMapping("/update")
    public String updateSpeciality(Specialty specialty, SpecialtyProperies specialtyProperies,
                                   ApplicationCampaign applicationCampaign, StudyFormat studyFormat) {
        specialtyProperies.setSpecialty(specialty);
        specialtyProperies.setApplicationCampaign(applicationCampaign);
        specialtyProperies.setStudyFormat(studyFormat);
        specialityPropJpaRepo.save(specialtyProperies);
        return "redirect:/api/faculty";
    }

    @GetMapping("/newSpeciality/{id}")
    public String goToCreateSpecialityPage(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("compaingList", applicationCompainJpaRepo.findAll());
        model.addAttribute("studyFormatList", studyFormatJpaRepo.findAll());
        return "newSpecialityPage";
    }

    @PostMapping("/createNew")
    public String createNewSpeciality(Specialty specialty, SpecialtyProperies specialtyProperies,
                                      ApplicationCampaign applicationCampaign, StudyFormat studyFormat) {
        specialtyProperies.setSpecialty(specialty);
        specialtyProperies.setStudyFormat(studyFormat);
        specialtyProperies.setApplicationCampaign(applicationCampaign);
        specialityPropJpaRepo.save(specialtyProperies);
        return "redirect:/api/faculty";
    }
}
