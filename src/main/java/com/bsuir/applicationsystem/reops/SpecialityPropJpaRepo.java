package com.bsuir.applicationsystem.reops;

import com.bsuir.applicationsystem.entity.Specialty;
import com.bsuir.applicationsystem.entity.SpecialtyProperies;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecialityPropJpaRepo extends JpaRepository<SpecialtyProperies, Integer> {
    List<SpecialtyProperies> getAllById(Integer id);

    List<SpecialtyProperies> findAll();

    SpecialtyProperies findBySpecialty(Specialty specialty);
}
