package com.bsuir.applicationsystem.entity;

import lombok.Data;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.persistence.*;

@Entity
@Data
@Table(name = "faculties")
@SQLDelete(sql = "UPDATE faculties SET status = 'DELETED' WHERE idfaculties = ? ", check = ResultCheckStyle.COUNT)
@Where(clause = "status <> 'DELETED'")
public class Faculty {

    @Id
    @GeneratedValue
    @Column(name = "idfaculties")
    private Long id;
    @Column
    private String faculty;
    @Column
    @Enumerated(EnumType.STRING)
    private Status status;


}
