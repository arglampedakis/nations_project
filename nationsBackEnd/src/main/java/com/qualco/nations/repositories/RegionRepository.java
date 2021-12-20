package com.qualco.nations.repositories;

import com.qualco.nations.models.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RegionRepository extends JpaRepository<Region, Integer>, JpaSpecificationExecutor<Region> {

}