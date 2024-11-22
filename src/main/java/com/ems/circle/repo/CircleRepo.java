package com.ems.circle.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.circle.model.Circle;

@Repository
public interface CircleRepo extends JpaRepository<Circle, Integer> {

}
