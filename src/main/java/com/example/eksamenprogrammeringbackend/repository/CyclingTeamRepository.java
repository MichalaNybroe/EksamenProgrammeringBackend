package com.example.eksamenprogrammeringbackend.repository;

import com.example.eksamenprogrammeringbackend.model.CyclingTeam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CyclingTeamRepository extends JpaRepository<CyclingTeam, Long> {
    CyclingTeam findByName(String cyclingTeamName);
}
