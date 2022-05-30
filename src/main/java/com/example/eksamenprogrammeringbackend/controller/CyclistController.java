package com.example.eksamenprogrammeringbackend.controller;

import com.example.eksamenprogrammeringbackend.model.Cyclist;
import com.example.eksamenprogrammeringbackend.service.CyclistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class CyclistController {

    @Autowired
    private CyclistService cyclistService;

    @GetMapping("/cyclist")
    public List<Cyclist> readAllCyclists(@RequestParam(required = false) String sort) {
        if (sort!= null) {
            switch (sort) {
                case "team":
                    return cyclistService.getAllCyclistSortedByCyclingTeam();
                case "mountain":
                    return cyclistService.getAllCyclistSortedByMountainScore();
                case "spurt":
                    return cyclistService.getAllCyclistSortedBySpurtPoints();
                case "ageTime":
                    return cyclistService.getAllCyclistSortedByAgeAndTime();
                default:
                    return cyclistService.getAllCyclistSortedByTotalTime();
            }
        }
        return cyclistService.readAllCyclist();
    }

    @GetMapping("/cyclist/{id}")
    public Optional<Cyclist> readCyclist(@PathVariable Long id) {
        return cyclistService.readCyclist(id);
    }

    @PostMapping("/cyclist")
    @ResponseStatus(HttpStatus.CREATED)
    public Cyclist createCyclist(@RequestBody Cyclist cyclist) {
        return cyclistService.createCyclist(cyclist);
    }

    @PutMapping("/cyclist/{id}")
    public Cyclist updateCyclist(@PathVariable Long id, @RequestBody Cyclist cyclist) {
        cyclist.setId(id);
        return cyclistService.updateCyclist(cyclist);
    }

    @DeleteMapping("/cyclist/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCyclist(@PathVariable Long id) {
        cyclistService.deleteCyclist(id);
    }
}
