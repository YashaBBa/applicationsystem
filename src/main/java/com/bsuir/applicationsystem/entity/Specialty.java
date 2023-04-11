package com.bsuir.applicationsystem.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@ToString
public class Specialty {
    @Id
    @GeneratedValue
    @Column(name = "idspecialty")
    private Long id;

    @Column(name = "specialty")
    private String specialtyName;
    @Column(name = "minimum_score")
    private int minimumScore;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "faculties_idfaculties")
    private Faculty faculty;

    @OneToMany(mappedBy = "specialty" )
    private List<Request> requestList;


}
