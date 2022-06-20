package com.example.eksamenprogrammeringbackend.repository;

import com.example.eksamenprogrammeringbackend.model.Cyclist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CyclistRepository extends JpaRepository<Cyclist, Long> {

    //Page<Cyclist> findAll(Pageable pageable, Sort sort);

    @Query("select c from Cyclist c order by c.cyclingTeam.name")
    List<Cyclist> findAllSortedByCyclingTeam();

    @Query("select c from Cyclist c order by c.totalTime")
    List<Cyclist> findAllSortedByTotalTime();

    @Query("select c from Cyclist c order by c.mountainPoints desc")
    List<Cyclist> findCyclistsSortedByMountainPoints();

    @Query("select c from Cyclist c order by c.spurtPoints desc")
    List<Cyclist> findCyclistSortedBySpurtPoints();

    @Query("select c from Cyclist c where c.age < 26 order by c.totalTime")
    List<Cyclist> findCyclistSortedByTimeAndAge();


}
