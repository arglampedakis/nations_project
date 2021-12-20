package com.qualco.nations.repositories;

import com.qualco.nations.models.Continent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ContinentRepository extends JpaRepository<Continent, Integer>, JpaSpecificationExecutor<Continent> {

}