package com.mss.admin.repo;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mss.admin.dto.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String user);

	@Modifying
	@Transactional
	@Query(value = "update user u set u.password=:password, u.user_id=:userid", nativeQuery = true)
	int updateUser(@Param("password") String password, @Param("userid") int userid);
}
