package com.ems.zone.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.zone.model.Zone;

public interface ZoneRepo extends JpaRepository<Zone, Integer> {

}
