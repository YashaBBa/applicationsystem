package com.bsuir.applicationsystem.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Date;

@Entity
@Data
@ToString
public class Request {
    @Id
    @GeneratedValue
    @Column(name = "request_id")
    private Long id;
    private Integer score;
    @Column
    @ColumnDefault(value = "1")
    private Integer look;
    private Integer position;

    private Date date;
    @ManyToOne
    @JoinColumn(name = "subjects_subjectid")
    private Subjects subjects;
    @ManyToOne
    @JoinColumn(name = "applicants_applicant_id")
    private Applicants applicants;
    @ManyToOne
    @JoinColumn(name = "speciality_id")
    private Specialty specialty;
}
