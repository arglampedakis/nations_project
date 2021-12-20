package com.qualco.nations.services;

import com.qualco.nations.dtos.RegionDTO;
import com.qualco.nations.mappers.RegionMapper;
import com.qualco.nations.models.Region;
import com.qualco.nations.repositories.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService{

    private final RegionRepository regionRepository;
    private final RegionMapper regionMapper;

    @Override
    public Region getById(Integer regionId){
        return regionRepository.getById(regionId);
    }

    @Override
    public List<RegionDTO> fetchAll() {
        return regionMapper.toDTOList(regionRepository.findAll());
    }

}
