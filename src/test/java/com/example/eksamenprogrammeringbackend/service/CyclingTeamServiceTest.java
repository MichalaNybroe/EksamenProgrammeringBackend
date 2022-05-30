package com.example.eksamenprogrammeringbackend.service;

import com.example.eksamenprogrammeringbackend.model.CyclingTeam;
import com.example.eksamenprogrammeringbackend.repository.CyclingTeamRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CyclingTeamServiceTest {

    @Mock
    private CyclingTeamRepository cyclingTeamRepository;

    @Test
    void readAll() {
        CyclingTeam cats = createTeam("cats", "Denmark");
        CyclingTeam dogs = createTeam("dogs", "Italy");

        List<CyclingTeam> teamList = new ArrayList<>();
        teamList.add(cats);
        teamList.add(dogs);

        Mockito.when(cyclingTeamRepository.findAll()).thenReturn(teamList);

        CyclingTeamService cyclingTeamService = new CyclingTeamService(cyclingTeamRepository);

        assertThat(cyclingTeamService.readAll()).isEqualTo(teamList);
    }

    CyclingTeam createTeam(String name, String country) {
        CyclingTeam cyclingTeam = new CyclingTeam();

        cyclingTeam.setName(name);
        cyclingTeam.setCountry(country);

        return cyclingTeam;
    }
}