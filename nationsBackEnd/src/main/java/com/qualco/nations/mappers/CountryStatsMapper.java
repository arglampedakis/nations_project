package com.qualco.nations.mappers;

import com.qualco.nations.dtos.CountryDTO;
import com.qualco.nations.dtos.CountryStatsDTO;
import com.qualco.nations.models.CountryStats;
import com.qualco.nations.services.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CountryStatsMapper {

    private final CountryService countryService;

    public CountryStatsDTO toDTO(CountryStats countryStats){
        CountryDTO countryDTO = countryService.fetchById(countryStats.getId().getCountryId());
        CountryStatsDTO countryStatsDTO = CountryStatsDTO.builder()
                .countryId(countryStats.getId().getCountryId())
                .year(countryStats.getId().getYear())
                .name(countryDTO.getName())
                .countryCode3(countryDTO.getCountryCode3())
                .gdp(countryStats.getGdp())
                .population(countryStats.getPopulation())
                .build();
        return countryStatsDTO;
    }

    public List<CountryStatsDTO> toDTOList(List<CountryStats> countryStatsList){
        List<CountryStatsDTO> countryStatsDTOList= new ArrayList<>();
        countryStatsList.stream()
                .forEach( countryStats -> countryStatsDTOList.add(toDTO(countryStats)));
        return countryStatsDTOList;
    }
}
