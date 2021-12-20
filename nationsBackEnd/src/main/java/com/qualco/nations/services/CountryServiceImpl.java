package com.qualco.nations.services;

import com.qualco.nations.dtos.CountryDTO;
import com.qualco.nations.mappers.CountryMapper;
import com.qualco.nations.models.Country;
import com.qualco.nations.repositories.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService{

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    @Override
    public List<CountryDTO> fetchAll(){
        List<Country> countries = countryRepository.findAll();
        return countryMapper.toDTOList(countries);
    }

    @Override
    public CountryDTO fetchById(Integer countryId) {
        return countryMapper.toDTO(
                countryRepository.getById(countryId));
    }

    @Override
    public Country fetchCountryById(Integer countryId) {
        return  countryRepository.getById(countryId);
    }


}
