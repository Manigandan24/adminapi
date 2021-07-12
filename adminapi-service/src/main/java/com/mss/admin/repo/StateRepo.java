package com.mss.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mss.admin.dto.State;


@Repository
public interface StateRepo extends JpaRepository<State, Integer> {
	
}
