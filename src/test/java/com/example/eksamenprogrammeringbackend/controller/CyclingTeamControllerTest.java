package com.example.eksamenprogrammeringbackend.controller;

import com.example.eksamenprogrammeringbackend.service.CyclingTeamService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CyclingTeamController.class)
class CyclingTeamControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CyclingTeamService cyclingTeamService;

    @Test
    void readAllCyclingTeams() throws Exception {
        // Mock Service
        Mockito.when(cyclingTeamService.readAll()).thenReturn(new ArrayList<>());

        // Mock Mvc kald
        this.mockMvc
                .perform(get("/cyclingTeam"))
                .andExpect(status()
                        .isOk()
                );

    }
}