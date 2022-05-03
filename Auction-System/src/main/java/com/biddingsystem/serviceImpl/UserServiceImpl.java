package com.biddingsystem.serviceImpl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.biddingsystem.model.Role;
import com.biddingsystem.model.User;
import com.biddingsystem.repository.RoleRepository;
import com.biddingsystem.repository.UserRepository;
import com.biddingsystem.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private RoleRepository roleRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getAllUser() throws Exception {
		return userRepository.findAll();
	}

	@Override
	public User registerUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Role roles = roleRepository.findByRole("ROLE_ADMIN").orElse(null);
		user.setRoles(Collections.singleton(roles));
		return userRepository.save(user);
	}

	@Override
	public User getUserByid(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public void updateUser(Long id, User user) throws Exception {
		User users = userRepository.findById(id).get();
		if (users != null) {
			users.setName(user.getName());
			users.setAddress(user.getAddress());
			users.setPhone_number(user.getPhone_number());
			users.setEmail(user.getEmail());
			users.setPassword(user.getPassword());
			userRepository.save(users);
		}
	}

	@Override
	public void deleteUser(Long id) throws Exception {
		userRepository.deleteById(id);
	}

	@Override
	public User findByName(String name) throws Exception {
		return userRepository.findByName(name);
	}

//	@Override
//	public Optional<User> findByName(String name) {
//		return userRepository.findByName(name);
//	}

//	@Override
//	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
//		Optional<User> user = userRepository.findByName(name);
//		user.orElseThrow(() -> new UsernameNotFoundException("Not found" + name));
//		return user.map(MyUserDetails::new).get();
//
//	}
}
