package com.example.eksamenprogrammeringbackend.service;

import com.example.eksamenprogrammeringbackend.model.CyclingTeam;
import com.example.eksamenprogrammeringbackend.model.Cyclist;
import com.example.eksamenprogrammeringbackend.repository.CyclingTeamRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CyclingTeamService {

    private final CyclingTeamRepository cyclingTeamRepository;

    public CyclingTeamService(CyclingTeamRepository cyclingTeamRepository) {
        this.cyclingTeamRepository = cyclingTeamRepository;
    }

    public List<CyclingTeam> readAll() {
        return cyclingTeamRepository.findAll();
    }

    public List<Cyclist> readAllCyclistsByCyclingTeam(String cyclingTeamName) {
        return cyclingTeamRepository.findByName(cyclingTeamName).getCyclists();
    }
}
