package com.bsuir.applicationsystem.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Subjects {
    @Id
    @GeneratedValue
    @Column(name = "subjectid")
    private Long id;
    String subject;


}
