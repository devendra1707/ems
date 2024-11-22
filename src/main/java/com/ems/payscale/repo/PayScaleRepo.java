package com.ems.payscale.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.payscale.model.PayScale;

@Repository
public interface PayScaleRepo extends JpaRepository<PayScale, Integer> {

}
