package com.soumyajitghosh.telecom.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.soumyajitghosh.telecom.user.jwt.SecurityJwt;
import com.soumyajitghosh.telecom.user.jwt.SignupDetails;
import com.soumyajitghosh.telecom.user.model.UserModel;
import com.soumyajitghosh.telecom.user.repository.UserRepo;

@Component
@Service
public class UserLoginService {

	
	@Autowired
	UserRepo repo;
	
	@Autowired
	AuthenticationManager authmanager;
	
	@Autowired
	SecurityJwt jwtUtils;
	
	
	
	public String register(UserModel user) {
		String idNumber = user.getUserNumber();
		if(repo.findByUserNumber(idNumber) == null) {
			BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
			user.setUserPassword(encoder.encode(user.getUserPassword()));
			repo.save(user);
			return "new user added";
		}
		return "user exist";
	}
	
	public String updateProfile(UserModel user,String id) {
		//BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		//UserModel oldUser = repo.findByUserNumber(jwtUtils.getUsername(id));
		UserModel oldUser = repo.findByUserNumber(id);
		oldUser.setUserAddress(user.getUserAddress());
		oldUser.setUserEmail(user.getUserEmail());
		oldUser.setUserName(user.getUserName());
		//user.setUserPassword(encoder.encode(user.getUserPassword()));
		repo.save(oldUser);
		return "User updated successfully!";
	}
	
	public String login(UserModel user) {
		try {
			Authentication auth=authmanager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserNumber(),
																								user.getUserPassword()));
			
			if(auth.isAuthenticated()) {
				SignupDetails details=new SignupDetails(user);
				
				return jwtUtils.generatetoken(details);
			}
			return "User is not authenticated";
		}
		catch(BadCredentialsException e) {
			
			return "phone no or password doesn't match";
		}
		catch(Exception er) {
			return "Error!!!";
		}
	}
	
	
}