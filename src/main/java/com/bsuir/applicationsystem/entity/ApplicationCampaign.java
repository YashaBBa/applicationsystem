package com.bsuir.applicationsystem.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name = "application_campaign")
public class ApplicationCampaign {
    @Id
    @GeneratedValue
    @Column(name = "application_campaign_id")
    private Long id;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "deadline_date")
    private Date deadlineDate;
}
