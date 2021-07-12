package com.mss.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mss.admin.dto.PolicyType;


@Repository
public interface PolicyTypeRepo extends JpaRepository<PolicyType, Integer> {

}
