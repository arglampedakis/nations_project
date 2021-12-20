package com.qualco.nations.services;

import com.qualco.nations.dtos.AnalyticRecordDTO;
import com.qualco.nations.mappers.AnalyticRecordMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnalyticsServiceImpl implements AnalyticsService{

    private final CountryStatsService countryStatsService;
    private final AnalyticRecordMapper analyticRecordMapper;

    @Override
    public List<AnalyticRecordDTO> fetchAll(){
        //TODO this is really slow
        return analyticRecordMapper.toAnalyticRecordDTOList(
                countryStatsService.fetchAll()
        );
    }


}
