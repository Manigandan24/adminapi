package com.mss.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mss.admin.dto.Coverage;

@Repository
public interface CoverageRepo  extends JpaRepository<Coverage, Integer> {

}
