package com.bsuir.applicationsystem.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "study_formats")
public class StudyFormat {
    @Id
    @GeneratedValue
    @Column(name = "study_format_id")
    private Long id;
    private String title;
}
