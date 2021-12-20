package com.qualco.nations.mappers;

import com.qualco.nations.dtos.LanguageDTO;
import com.qualco.nations.models.Language;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface LanguageMapper {

    LanguageDTO toDTO(Language language);

    Language toLanguage(LanguageDTO languageDTO);

    List<LanguageDTO> toDTOList(List<Language> languages);

    List<Language> toList(List<LanguageDTO> languageDTOS);
}
