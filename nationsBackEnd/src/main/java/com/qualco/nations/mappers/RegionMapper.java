package com.qualco.nations.mappers;

import com.qualco.nations.dtos.RegionDTO;
import com.qualco.nations.models.Region;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface RegionMapper {

    RegionDTO toDTO(Region region);

    Region toLanguage(RegionDTO regionDTO);

    List<RegionDTO> toDTOList(List<Region> regions);

    List<Region> toList(List<RegionDTO> regionDTOS);
}
