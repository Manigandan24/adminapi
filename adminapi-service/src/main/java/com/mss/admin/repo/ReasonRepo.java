package com.mss.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mss.admin.dto.Reason;


@Repository
public interface ReasonRepo extends JpaRepository<Reason, Integer> {

}
