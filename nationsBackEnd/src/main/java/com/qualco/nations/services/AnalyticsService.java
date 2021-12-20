package com.qualco.nations.services;

import com.qualco.nations.dtos.AnalyticRecordDTO;

import java.util.List;

public interface AnalyticsService {

    List<AnalyticRecordDTO> fetchAll();
}
