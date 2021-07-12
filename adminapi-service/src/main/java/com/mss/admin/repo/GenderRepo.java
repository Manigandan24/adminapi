package com.mss.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mss.admin.dto.Gender;


@Repository
public interface GenderRepo extends JpaRepository<Gender, Integer> {

}
