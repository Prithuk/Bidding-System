package com.biddingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.biddingsystem.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.biddingsystem.model.User user = repository.findByName(username);
		if (user == null) {
			throw new UsernameNotFoundException("User does not exist with name:" + username);
		}
		return User.builder().username(user.getName()).password(user.getPassword()).authorities(
				user.getRoles().
				stream().
				map(role -> "ROLE_" + role.getRole()).toList().toArray(new String[] {}))
				.build();
	}
}
