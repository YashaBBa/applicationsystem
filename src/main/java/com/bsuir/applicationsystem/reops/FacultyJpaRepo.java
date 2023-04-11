package com.bsuir.applicationsystem.reops;

import com.bsuir.applicationsystem.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacultyJpaRepo extends JpaRepository<Faculty, Long> {
    List<Faculty> findAll();

}
