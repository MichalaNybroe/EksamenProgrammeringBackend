package com.example.eksamenprogrammeringbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class CyclingTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String country;

    @JsonBackReference
    @OneToMany(mappedBy = "cyclingTeam", fetch = FetchType.EAGER)
    private List<Cyclist> cyclists;
}
