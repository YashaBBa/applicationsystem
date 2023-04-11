package com.bsuir.applicationsystem.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "scpecialty_properties")
@ToString
public class SpecialtyProperies {
    @Id
    @GeneratedValue
    @Column(name = "idtable1")
    private Integer id;
    @Column(name = "preferential_places")
    private Integer prefPlaces;
    @Column
    private Integer places;
    @Column
    private Double cost;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "application_campaign_id", columnDefinition = "integer default 1")
    private ApplicationCampaign applicationCampaign;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "study_formats_study_format_id", columnDefinition = "integer default 1")
    private StudyFormat studyFormat;


}
