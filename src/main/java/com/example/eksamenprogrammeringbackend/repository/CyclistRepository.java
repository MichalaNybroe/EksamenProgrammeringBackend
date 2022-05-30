package com.example.eksamenprogrammeringbackend.repository;

import com.example.eksamenprogrammeringbackend.model.Cyclist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CyclistRepository extends JpaRepository<Cyclist, Long> {
    @Query("select c from Cyclist c order by c.cyclingTeam.name")
    List<Cyclist> findAllSortedByCyclingTeam();

    @Query("select c from Cyclist c order by c.totalTime")
    List<Cyclist> findAllSortedByTotalTime();
}
