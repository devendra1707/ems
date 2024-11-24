package com.ems.state.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.state.model.State;

public interface StateRepo extends JpaRepository<State, Integer> {

}
