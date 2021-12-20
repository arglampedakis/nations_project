package com.qualco.nations.services;

import com.qualco.nations.dtos.LanguageDTO;

import java.util.List;

public interface LanguageService {

    List<LanguageDTO> fetchByCountryId(Integer countryId);
}
