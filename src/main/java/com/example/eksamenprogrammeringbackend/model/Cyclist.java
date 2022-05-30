package com.example.eksamenprogrammeringbackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Getter
@Setter
public class Cyclist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    private String middleName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private int age;

    private Time totalTime;

    private int mountainPoints;

    private int spurtPoints;

    @Column(nullable = false)
    private String nationality;

    @ManyToOne
    @JoinColumn
    private CyclingTeam cyclingTeam;

}
