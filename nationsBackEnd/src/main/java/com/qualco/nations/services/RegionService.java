package com.qualco.nations.services;

import com.qualco.nations.dtos.RegionDTO;
import com.qualco.nations.models.Region;

import java.util.List;

public interface RegionService {

    Region getById(Integer regionId);

    List<RegionDTO> fetchAll();
}
