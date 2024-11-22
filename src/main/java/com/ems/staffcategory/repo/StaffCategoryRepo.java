package com.ems.staffcategory.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.staffcategory.model.StaffCategory;

@Repository
public interface StaffCategoryRepo extends JpaRepository<StaffCategory, Integer> {

}
