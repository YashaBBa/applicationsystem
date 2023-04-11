package com.bsuir.applicationsystem.service.impl;

import com.bsuir.applicationsystem.entity.Applicants;
import com.bsuir.applicationsystem.entity.Request;
import com.bsuir.applicationsystem.entity.Specialty;
import com.bsuir.applicationsystem.entity.SpecialtyProperies;
import com.bsuir.applicationsystem.reops.ApplicantJpaRepo;
import com.bsuir.applicationsystem.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private ApplicantJpaRepo applicantJpaRepo;


    @Override
    public Boolean addUserInGreenList(Integer specialityId, Long applicantId) {
        applicantJpaRepo.applyUser(specialityId, applicantId);
        return null;
    }

    @Override
    public Boolean addUserInGreenList(Applicants applicants, SpecialtyProperies specialtyProperies) {
        applicants.setSpecialtyProperies(specialtyProperies);
        applicantJpaRepo.save(applicants);
        return true;
    }

    @Override
    public void applyAllApplicantsMyScoreAndPriority(List<SpecialtyProperies> specialtyProperiesList) {
        List<Request> requestList = new ArrayList<>();
        Boolean apply = false;


        for (int i = 1; i < 6; i++) {
            for (int j = 0; j < 2; j++) {
                for (SpecialtyProperies specialtyProperies : specialtyProperiesList) {

                    for (Request request : specialtyProperies.getSpecialty().getRequestList()) {
                        int applicantRatingPlace = specialtyProperies.getSpecialty().getRequestList().indexOf(request);

                        if (applicantRatingPlace < specialtyProperies.getPlaces() && request.getPosition() == i) {
                            // apply = addUserInGreenList(specialtyProperies.getId(), request.getApplicants().getId());
                            apply = addUserInGreenList(request.getApplicants(), specialtyProperies);
                            specialtyProperies.setPlaces(specialtyProperies.getPlaces() - 1);
                            System.out.println(request.getApplicants().getName() + " " + request.getScore().toString() + " Apply this dude");
                            requestList.add(request);


                        }
                    }
                    if (apply) {
                        for (Request request : requestList) {
                            specialtyProperies.getSpecialty().getRequestList().remove(request);
                        }
                        apply = false;
                    }

                }


            }
        }

    }
}
