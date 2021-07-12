package com.mss.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mss.admin.dto.LineOfBusiness;


@Repository
public interface LobRepo extends JpaRepository<LineOfBusiness, Integer> {

}
