package com.qualco.nations.services;

import com.qualco.nations.dtos.CountryDTO;
import com.qualco.nations.models.Country;

import java.util.List;

public interface CountryService {

    List<CountryDTO> fetchAll();

    CountryDTO fetchById(Integer countryId);

    Country fetchCountryById(Integer countryId);
}
