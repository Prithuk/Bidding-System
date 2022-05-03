package com.biddingsystem.dto;

import java.util.Set;

import com.biddingsystem.model.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginDto {

	private Long id;
	private String name;
	private Set<String> roles;

}
