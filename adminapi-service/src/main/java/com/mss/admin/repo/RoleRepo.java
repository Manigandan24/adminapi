package com.mss.admin.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mss.admin.dto.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer>  {

	@Modifying
	@Transactional
	@Query(value="delete role where  role_id=:role_id",nativeQuery=true)
	int deleteRole(@Param("role_id") int role_id );
}
