package com.bsuir.applicationsystem.service;

import com.bsuir.applicationsystem.entity.Applicants;
import com.bsuir.applicationsystem.entity.Specialty;
import com.bsuir.applicationsystem.entity.SpecialtyProperies;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ApplicationService {
    Boolean addUserInGreenList(Integer applicantId, Long specialityId);
    Boolean addUserInGreenList(Applicants applicants, SpecialtyProperies specialtyProperies);

    void applyAllApplicantsMyScoreAndPriority(List<SpecialtyProperies> specialtyProperiesList);
}
