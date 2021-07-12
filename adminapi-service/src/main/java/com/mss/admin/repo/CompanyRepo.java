package com.mss.admin.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mss.admin.dto.Company;

@Repository
public interface CompanyRepo extends JpaRepository<Company, Integer>{

	@Modifying
	@Transactional
	@Query(value="delete Company where  id=:id",nativeQuery=true)
	int deleteCompany(@Param("id") int id );
}
