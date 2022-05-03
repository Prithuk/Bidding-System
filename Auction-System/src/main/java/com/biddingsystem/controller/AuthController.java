//package com.biddingsystem.controller;
//
//import java.util.Collections;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.biddingsystem.dto.LoginDto;
//import com.biddingsystem.dto.SignUpDto;
//import com.biddingsystem.model.Role;
//import com.biddingsystem.model.User;
//import com.biddingsystem.repository.RoleRepository;
//import com.biddingsystem.repository.UserRepository;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//
//	@Autowired
//	private AuthenticationManager authenticationManager;
//
//	@Autowired
//	private UserRepository userRepository;
//
//	@Autowired
//	private RoleRepository roleRepository;
//
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//
//	@PostMapping("/signin")
//	public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto) {
//		Authentication authentication = authenticationManager
//				.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getName(), loginDto.getPassword()));
//
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//		return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
//	}
//
//	@PostMapping("/signup")
//	public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto) {
//		User user = new User();
//		user.setName(signUpDto.getName());
//		user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
//		user.setAddress(signUpDto.getAddress());
//		user.setEmail(signUpDto.getEmail());
//		user.setPhone_number(signUpDto.getPhone_number());
//
//		Role roles = roleRepository.findByRole("ROLE_ADMIN").get();
//		user.setRoles(Collections.singleton(roles));
//		userRepository.save(user);
//		return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
//
//	}
//
//}
