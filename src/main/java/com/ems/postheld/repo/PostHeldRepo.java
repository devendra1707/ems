package com.ems.postheld.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.postheld.model.PostHeld;

public interface PostHeldRepo extends JpaRepository<PostHeld, Integer> {

}
