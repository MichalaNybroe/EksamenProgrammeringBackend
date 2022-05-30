package com.example.eksamenprogrammeringbackend.controller;

import com.example.eksamenprogrammeringbackend.service.CyclistService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(CyclistController.class)
class CyclistControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CyclistService cyclistService;

    // test uden sort
    @Test
    void readAllCyclists() throws Exception {
        Mockito.when(cyclistService.readAllCyclist()).thenReturn(new ArrayList<>());

        this.mockMvc
                .perform(get("/cyclist"))
                .andExpect(status()
                        .isOk()
                );
    }

    // test med en sort
    @Test
    void readAllCyclistsSortedByTeam() throws Exception {
        Mockito.when(cyclistService.getAllCyclistSortedByCyclingTeam()).thenReturn(new ArrayList<>());

        this.mockMvc
                .perform(get("/cyclist?sort=team"))
                .andExpect(status()
                        .isOk()
                );
    }
}