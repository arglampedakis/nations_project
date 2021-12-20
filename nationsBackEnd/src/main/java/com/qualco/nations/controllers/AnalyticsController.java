package com.qualco.nations.controllers;

import com.qualco.nations.dtos.AnalyticRecordDTO;
import com.qualco.nations.services.AnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/analytics")
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET})
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AnalyticRecordDTO>> fetchAll(){
        List<AnalyticRecordDTO> analyticRecordDTOList = analyticsService.fetchAll();
        return new ResponseEntity<>(analyticRecordDTOList, HttpStatus.OK);
    }
}
