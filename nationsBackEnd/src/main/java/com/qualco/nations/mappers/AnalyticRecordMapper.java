package com.qualco.nations.mappers;

import com.qualco.nations.dtos.AnalyticRecordDTO;
import com.qualco.nations.models.Continent;
import com.qualco.nations.models.Country;
import com.qualco.nations.models.CountryStats;
import com.qualco.nations.models.Region;
import com.qualco.nations.services.ContinentService;
import com.qualco.nations.services.CountryService;
import com.qualco.nations.services.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AnalyticRecordMapper {

    private final CountryService countryService;
    private final RegionService regionService;
    private final ContinentService continentService;

    public AnalyticRecordDTO toAnalyticRecordDTO(CountryStats countryStats){
        //TODO this is really slow
        Country country = countryService.fetchCountryById(countryStats.getId().getCountryId());
        Region region = regionService.getById(country.getRegionId());
        Continent continent = continentService.getById(region.getContinentId());

        AnalyticRecordDTO analyticRecordDTO = AnalyticRecordDTO.builder()
                .countryId(countryStats.getId().getCountryId())
                .countryName(country.getName())
                .regionName(region.getName())
                .continentName(continent.getName())
                .year(countryStats.getId().getYear())
                .gdp(countryStats.getGdp())
                .population(countryStats.getPopulation())
                .build();
        return analyticRecordDTO;
    }

    public List<AnalyticRecordDTO> toAnalyticRecordDTOList(List<CountryStats> countryStatsList){
        //TODO this is really slow
        List<AnalyticRecordDTO> list = new ArrayList<>();
        countryStatsList.stream()
                .forEach( countryStats -> list.add(toAnalyticRecordDTO(countryStats)));
        return list;
    }

}
