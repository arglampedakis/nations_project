package com.qualco.nations.mappers;

import com.qualco.nations.dtos.CountryDTO;
import com.qualco.nations.models.Country;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CountryMapper {

    CountryDTO toDTO(Country country);

    Country toCountry(CountryDTO countryDTO);

    List<CountryDTO> toDTOList(List<Country> countries);

    List<Country> toList(List<CountryDTO> countryDTOS);
}
