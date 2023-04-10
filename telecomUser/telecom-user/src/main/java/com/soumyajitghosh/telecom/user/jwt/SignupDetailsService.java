package com.soumyajitghosh.telecom.user.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.soumyajitghosh.telecom.user.model.UserModel;
import com.soumyajitghosh.telecom.user.repository.UserRepo;

@Service 
public class SignupDetailsService implements UserDetailsService{

	
	@Autowired
	UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String userNumber) throws UsernameNotFoundException {
		//*********************************************************//
		UserModel usermodel=repo.findByUserNumber(userNumber);
		return new SignupDetails(usermodel);
	}

}