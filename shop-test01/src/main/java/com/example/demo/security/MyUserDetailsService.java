package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.domain.entity.GreenMemberEntityRepository;

public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private GreenMemberEntityRepository dao;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return new MyUserDetails(dao.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("UsernameNotFound!!")));
	}

}
