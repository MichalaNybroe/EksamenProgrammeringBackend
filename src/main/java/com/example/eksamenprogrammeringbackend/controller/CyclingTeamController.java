package com.example.eksamenprogrammeringbackend.controller;

import com.example.eksamenprogrammeringbackend.model.CyclingTeam;
import com.example.eksamenprogrammeringbackend.model.Cyclist;
import com.example.eksamenprogrammeringbackend.service.CyclingTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CyclingTeamController {

    @Autowired
    private CyclingTeamService cyclingTeamService;

    @GetMapping("/cyclingTeam")
    public List<CyclingTeam> readAllCyclingTeams() {
        return cyclingTeamService.readAll();
    }

    @GetMapping("/cyclingTeam/{cyclingTeamName}/cyclist")
    public List<Cyclist> readAllCyclistByCyclistTeam(@PathVariable String cyclingTeamName) {
        return cyclingTeamService.readAllCyclistsByCyclingTeam(cyclingTeamName);
    }
}
