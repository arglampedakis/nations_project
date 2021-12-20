package com.qualco.nations.repositories;

import com.qualco.nations.models.CountryStats;
import com.qualco.nations.models.CountryStatsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryStatsRepository extends JpaRepository<CountryStats, CountryStatsId> {

    @Query(
            value = "SELECT A.* FROM COUNTRY_STATS A GROUP BY A.country_id HAVING MAX(A.gdp / A.population)",
            nativeQuery = true)
    List<CountryStats> findMaxGdpPerPopulationRatioStats();

}
