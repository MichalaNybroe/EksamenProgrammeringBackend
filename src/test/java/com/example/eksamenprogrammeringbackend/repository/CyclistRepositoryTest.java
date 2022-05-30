package com.example.eksamenprogrammeringbackend.repository;

import com.example.eksamenprogrammeringbackend.model.CyclingTeam;
import com.example.eksamenprogrammeringbackend.model.Cyclist;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Time;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CyclistRepositoryTest {

    @Autowired
    private CyclistRepository cyclistRepository;

    @Autowired
    private CyclingTeamRepository cyclingTeamRepository;

    @Test
    void saveCandidate() {
        CyclingTeam cyclingTeam = createCyclingTeam("Speeders", "Belgium");

        Time time = Time.valueOf("01:55:59");

        Cyclist cyclist = createCyclist(
                "Hans",
                null,
                "Peterson",
                25,
                time,
                0,
                0,
                "Belgium",
                cyclingTeam
        );

        // Tjek at den blev oprettet ved at tjekke om en cyklist med det id blev oprettet
        // og om der er 1 cyklist i db
        assertThat(cyclistRepository.findById(cyclist.getId())).isNotNull();
        assertThat(cyclistRepository.count()).isEqualTo(1);
    }

    @Test
    void findAllSortedByCyclingTeam() {
        CyclingTeam dogs = createCyclingTeam("Dogs", "Finland");
        CyclingTeam cats = createCyclingTeam("Cats", "Denmark");
        CyclingTeam bats = createCyclingTeam("Bats", "France");

        Time time = Time.valueOf("01:55:59");

        Cyclist dogs1 = createCyclist("Harry", "James", "Potter", 35, time, 2, 3, "Finland", dogs);
        Cyclist dogs2 = createCyclist("Ron", null, "Weasley", 35, time, 5, 2, "England", dogs);
        Cyclist cats1 = createCyclist("Dolores", null, "Umbridge", 67, time, 0, 0, "England", cats);
        Cyclist cats2 = createCyclist("Sheamus", null, "Finnigan", 35, time, 0, 0, "England", cats);
        Cyclist cats3 = createCyclist("Filip", null, "Løvehjerte", 14, time, 5, 9, "Finland", cats);
        Cyclist bats1 = createCyclist("Filip", null, "Engel", 16, time, 2, 4, "Croatia", bats);

        List<Cyclist> cyclistList = cyclistRepository.findAllSortedByCyclingTeam();


        // Tjek at listen har 6 cyklister
        // Tjek at rækkefølgen er præcis nedenstående i udhentede liste
        // Heri testes query som skal udhente sorteret på team navn
        assertThat(cyclistList).hasSize(6);
        assertThat(cyclistList).containsExactly(
                bats1,
                cats1,
                cats2,
                cats3,
                dogs1,
                dogs2
        );
    }


    // Hjælpe metoder til at gemme cyklister og hold
    CyclingTeam createCyclingTeam(String name, String country) {
        CyclingTeam cyclingTeam = new CyclingTeam();
        cyclingTeam.setName(name);
        cyclingTeam.setCountry(country);
        cyclingTeam = cyclingTeamRepository.save(cyclingTeam);
        return cyclingTeam;
    }

    Cyclist createCyclist(String firstname, String middlename, String lastname, int age, Time time, int mp, int sp, String nationality, CyclingTeam team) {
        Cyclist cyclist = new Cyclist();
        cyclist.setFirstName(firstname);
        cyclist.setMiddleName(middlename);
        cyclist.setLastName(lastname);
        cyclist.setAge(age);
        cyclist.setTotalTime(time);
        cyclist.setMountainPoints(mp);
        cyclist.setSpurtPoints(sp);
        cyclist.setNationality(nationality);
        cyclist.setCyclingTeam(team);
        cyclist = cyclistRepository.save(cyclist);
        return cyclist;
    }
}