package com.bsuir.applicationsystem.reops;

import com.bsuir.applicationsystem.entity.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectJpaRepo extends JpaRepository<Subjects, Long> {

}
