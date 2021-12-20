package com.qualco.nations.services;

import com.qualco.nations.dtos.CountryStatsDTO;
import com.qualco.nations.mappers.CountryStatsMapper;
import com.qualco.nations.models.CountryStats;
import com.qualco.nations.repositories.CountryStatsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryStatsServiceImpl implements CountryStatsService{

    private final CountryStatsRepository countryStatsRepository;
    private final CountryStatsMapper countryStatsMapper;

    @Override
    public List<CountryStatsDTO> fetchMaxGdpPerPopulationRatioStats() {
        List<CountryStats> countryStatsList = countryStatsRepository.findMaxGdpPerPopulationRatioStats();
        return countryStatsMapper.toDTOList(countryStatsList);
    }

    @Override
    public List<CountryStats> fetchAll() {
        return countryStatsRepository.findAll();
    }
}
