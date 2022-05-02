package com.biddingsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.biddingsystem.model.User;

@Service
public interface UserService {
	public List<User> getAllUser() throws Exception;

	public User registerUser(User user) throws Exception;

	public void updateUser(Long id, User user) throws Exception;

	public User getUserByid(Long id);

	public void deleteUser(Long id) throws Exception;

	public User findByName(String name) throws Exception;

//	Optional<User> findByName(String name) throws Exception;

//	public User findByEmail(String email) throws Exception;
//
//	public User findByUsernameOrEmail(String username, String email) throws Exception;
//

//
//	public  Boolean existsByUsername(String username);
//
//	public  Boolean existsByEmail(String email);

}
