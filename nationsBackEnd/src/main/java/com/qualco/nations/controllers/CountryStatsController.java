package com.qualco.nations.controllers;

import com.qualco.nations.dtos.CountryStatsDTO;
import com.qualco.nations.services.CountryStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/countryStats")
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET})
public class CountryStatsController {

    private final CountryStatsService countryStatsService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CountryStatsDTO>> fetchMaxGdpPerPopulationRatioStats(){
        List<CountryStatsDTO> countryStatsDTOList = countryStatsService.fetchMaxGdpPerPopulationRatioStats();
        return new ResponseEntity<>(countryStatsDTOList, HttpStatus.OK);
    }
}
