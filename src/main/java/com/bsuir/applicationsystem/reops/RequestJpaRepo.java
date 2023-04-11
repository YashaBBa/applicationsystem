package com.bsuir.applicationsystem.reops;

import com.bsuir.applicationsystem.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RequestJpaRepo extends JpaRepository<Request, Integer> {
    @Query(value = "select max(r.position) from Request r where r.applicants.id=?1")
    Integer findMaxPriorityByApplicant(Long id);
}
