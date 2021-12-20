package com.qualco.nations.services;

import com.qualco.nations.dtos.CountryStatsDTO;
import com.qualco.nations.models.CountryStats;

import java.util.List;

public interface CountryStatsService {

    List<CountryStatsDTO> fetchMaxGdpPerPopulationRatioStats();

    List<CountryStats> fetchAll();
}
