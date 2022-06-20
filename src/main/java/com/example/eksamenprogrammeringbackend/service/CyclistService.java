package com.example.eksamenprogrammeringbackend.service;

import com.example.eksamenprogrammeringbackend.model.Cyclist;
import com.example.eksamenprogrammeringbackend.repository.CyclistRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CyclistService {

    private final CyclistRepository cyclistRepository;

    public CyclistService(CyclistRepository cyclistRepository) {
        this.cyclistRepository = cyclistRepository;
    }

    public List<Cyclist> readAllCyclist() {
        return cyclistRepository.findAll();
    }

    public Cyclist createCyclist(Cyclist cyclist) {
        return cyclistRepository.save(cyclist);
    }

    public Cyclist updateCyclist(Cyclist cyclist) {
        return cyclistRepository.save(cyclist);
    }

    public void deleteCyclist(Long id) {
        cyclistRepository.deleteById(id);
    }

    public List<Cyclist> getAllCyclistSortedByCyclingTeam() {
        //return cyclistRepository.findAll(pageable, Sort.by("cyclingTeam.name"));
        return cyclistRepository.findAllSortedByCyclingTeam();
    }

    public List<Cyclist> getAllCyclistSortedByTotalTime() {
        return cyclistRepository.findAllSortedByTotalTime();
    }

    public Optional<Cyclist> readCyclist(Long id) {
        return cyclistRepository.findById(id);
    }

    public List<Cyclist> getAllCyclistSortedByMountainScore() {
        return cyclistRepository.findCyclistsSortedByMountainPoints();
    }

    public List<Cyclist> getAllCyclistSortedBySpurtPoints() {
        return cyclistRepository.findCyclistSortedBySpurtPoints();
    }

    public List<Cyclist> getAllCyclistSortedByAgeAndTime() {
        return cyclistRepository.findCyclistSortedByTimeAndAge();
    }
}
