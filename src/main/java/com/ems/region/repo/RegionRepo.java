package com.ems.region.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.region.model.Region;

public interface RegionRepo extends JpaRepository<Region, Integer> {

}
