package com.ems.station.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.station.model.Station;

@Repository
public interface StationRepo extends JpaRepository<Station, Integer> {

	
}
