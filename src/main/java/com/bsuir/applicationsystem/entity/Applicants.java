package com.bsuir.applicationsystem.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@ToString
public class Applicants {
    @Id
    @GeneratedValue
    @Column(name = "applicant_id")
    private Long id;

    String name;
    String surname;
    String passport;
    @Column(name = "study_format")
    String studyFormat;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "scpecialty_properties_idtable1")
    private SpecialtyProperies specialtyProperies;


}
