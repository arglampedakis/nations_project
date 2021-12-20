package com.qualco.nations.repositories;

import com.qualco.nations.models.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LanguageRepository extends JpaRepository<Language, Integer>, JpaSpecificationExecutor<Language> {

    @Query(
            value = "SELECT L.* FROM LANGUAGES L JOIN COUNTRY_LANGUAGES C ON L.LANGUAGE_ID = C.LANGUAGE_ID WHERE C.COUNTRY_ID = :countryId",
            nativeQuery = true)
    List<Language> findByCountryId(@Param("countryId") Integer countryId);
}