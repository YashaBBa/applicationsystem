package com.bsuir.applicationsystem.reops;

import com.bsuir.applicationsystem.entity.SpecialtyHasSubjects;
import com.bsuir.applicationsystem.entity.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpecPropHasSubRepo extends JpaRepository<SpecialtyHasSubjects, Integer> {
    @Query(value = "SELECT t FROM SpecialtyHasSubjects t where t.specialtyProperies.id=?1")
    List<SpecialtyHasSubjects> findAllBySpecialtyProperies(Integer id);

    //List<SpecialtyHasSubjects> findAll();
}
