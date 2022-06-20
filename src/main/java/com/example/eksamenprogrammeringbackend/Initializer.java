package com.example.eksamenprogrammeringbackend;

import com.example.eksamenprogrammeringbackend.model.CyclingTeam;
import com.example.eksamenprogrammeringbackend.repository.CyclingTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Initializer implements ApplicationRunner {
    @Autowired
    private CyclingTeamRepository cyclingTeamRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        CyclingTeam team = new CyclingTeam();
        team.setCountry("Danish");
        team.setName("Cats");

        CyclingTeam team2 = new CyclingTeam();
        team2.setCountry("German");
        team2.setName("Dogs");
        cyclingTeamRepository.save(team);
        cyclingTeamRepository.save(team2);
    }
}
