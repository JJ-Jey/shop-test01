package com.example.demo.security;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.example.demo.domain.entity.MemberEntity;

import lombok.Getter;

@Getter
public class MyUserDetails extends User {
	
	private String email;
	
	public MyUserDetails(MemberEntity entity) {
		super(entity.getEmail(), entity.getPass(), entity.getRoles().stream()
				.map((role)->new SimpleGrantedAuthority("ROLE_"+role.name()))
				.collect(Collectors.toSet()));
		
		this.email=entity.getEmail();
	}

}
