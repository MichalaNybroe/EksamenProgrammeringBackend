package com.example.eksamenprogrammeringbackend.repository;

import com.example.eksamenprogrammeringbackend.model.CyclingTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CyclingTeamRepository extends JpaRepository<CyclingTeam, Long> {
    CyclingTeam findByName(String cyclingTeamName);

   /* @Query("select t from CyclingTeam t join t.cyclists c on c.id order by c.totalTime")
    List<CyclingTeam> findTopSortedByTopCyclists();

    @Query("select t.country from CyclingTeam t join t.cyclists c on c.id order by c.totalTime")
    List<String> findBestCountries();

    */
}
