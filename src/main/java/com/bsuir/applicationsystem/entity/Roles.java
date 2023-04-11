package com.bsuir.applicationsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "roles")
@AllArgsConstructor
public class Roles {
    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "titile")
    private Role role;

    private String roles;

    public Roles() {

    }
}
