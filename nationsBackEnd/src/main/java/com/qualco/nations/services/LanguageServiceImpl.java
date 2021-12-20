package com.qualco.nations.services;

import com.qualco.nations.dtos.LanguageDTO;
import com.qualco.nations.mappers.LanguageMapper;
import com.qualco.nations.models.Language;
import com.qualco.nations.repositories.LanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;
    private final LanguageMapper languageMapper;

    public List<LanguageDTO> fetchByCountryId(Integer countryId){
        List<Language> languages = languageRepository.findByCountryId(countryId);
        return languageMapper.toDTOList(languages);
    }

}
