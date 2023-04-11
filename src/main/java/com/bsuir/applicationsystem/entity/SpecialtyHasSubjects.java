package com.bsuir.applicationsystem.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "scpecialty_properties_has_subjects")
public class SpecialtyHasSubjects {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "scpecialty_properties_idtable1")
    private SpecialtyProperies specialtyProperies;
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "subjects_subjectid")
    private Subjects subjects;

}
