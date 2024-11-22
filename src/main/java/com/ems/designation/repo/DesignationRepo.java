package com.ems.designation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.designation.model.Designation;

public interface DesignationRepo extends JpaRepository<Designation, Integer> {

}
