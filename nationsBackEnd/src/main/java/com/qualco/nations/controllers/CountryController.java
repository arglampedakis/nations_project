package com.qualco.nations.controllers;

import com.qualco.nations.dtos.CountryDTO;
import com.qualco.nations.services.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/country")
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET})
public class CountryController {

    private final CountryService countryService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CountryDTO>> fetchAll(){
        List<CountryDTO> countryDTOList = countryService.fetchAll();
        return new ResponseEntity<>(countryDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CountryDTO> fetchById(@PathVariable("id") Integer countryId){
        CountryDTO countryDTO = countryService.fetchById(countryId);
        return new ResponseEntity<>(countryDTO, HttpStatus.OK);
    }



}
