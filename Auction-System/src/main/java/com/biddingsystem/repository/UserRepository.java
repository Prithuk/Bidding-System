package com.biddingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biddingsystem.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByName(String name);
	
	
//	Optional<User> findByName(String name);

//	User findByEmail(String email);
//
//	User findByUsernameOrEmail(String username, String email);

//	Boolean existsByUsername(String username);
//
//	Boolean existsByEmail(String email);
}
