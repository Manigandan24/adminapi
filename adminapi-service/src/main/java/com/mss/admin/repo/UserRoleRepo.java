package com.mss.admin.repo;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mss.admin.dto.UserRole;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRole, Integer>  {

	Optional<UserRole> findBycode(String role);
	
	@Modifying
	@Transactional
	@Query(value="insert into user_role(code,value,user_role_id) values(:code,:value,:user_role_id)",nativeQuery=true)
	int addRole(@Param("code") String code, @Param("value") String value,@Param("user_role_id") int user_role_id );
	
	@Modifying
	@Transactional
	@Query(value="delete user_role where code=:code and user_role_id=:user_role_id",nativeQuery=true)
	int deleteRole(@Param("code") String code, @Param("user_role_id") int user_role_id );
}
