package com.bsuir.applicationsystem.reops;

import com.bsuir.applicationsystem.entity.Applicants;
import com.bsuir.applicationsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.CriteriaBuilder;

public interface ApplicantJpaRepo extends JpaRepository<Applicants, Long> {
    @Modifying
    @Query(value = "UPDATE Applicants a set a.specialtyProperies.id=?1 where a.id=?2")
    void applyUser(Integer specialityPropId, Long applicantId);

    Applicants findByUser(User user);
}
