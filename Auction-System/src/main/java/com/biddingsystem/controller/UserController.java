package com.biddingsystem.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biddingsystem.dto.LoginDto;
import com.biddingsystem.model.Role;
import com.biddingsystem.model.User;
import com.biddingsystem.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	UserService userService;

	// for authentication
	@GetMapping("/authenticate")
	public ResponseEntity<LoginDto> authenticate(Authentication authentication) {
		String name = authentication.getName();
		User user = userService.findByName(name);
		LoginDto loginDto = LoginDto.builder().id(user.getId()).name(user.getName())
				.roles(user.getRoles().stream().map(Role::getRole).collect(Collectors.toSet())).build();
		return new ResponseEntity<>(loginDto, HttpStatus.OK);
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<User>> getAllUser() throws Exception {
		List<User> userList = userService.getAllUser();
		return new ResponseEntity<>(userList, HttpStatus.OK);
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping("/add")
	public ResponseEntity<User> createUser(@RequestBody User user) throws Exception {
		return new ResponseEntity<>(userService.registerUser(user), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) throws Exception {
		userService.updateUser(id, user);
		return new ResponseEntity<>(userService.getUserByid(id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUsers(@PathVariable("id") Long id) throws Exception {
		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
