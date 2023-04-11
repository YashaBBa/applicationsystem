package com.bsuir.applicationsystem.reops;


import com.bsuir.applicationsystem.entity.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpecialityJpaRep extends JpaRepository<Specialty, Long> {
    List<Specialty> findAll();

    List<Specialty> findByFacultyId(Long id);

    Optional<Specialty> findById(Long id);

    Specialty getById(Long id);

}
