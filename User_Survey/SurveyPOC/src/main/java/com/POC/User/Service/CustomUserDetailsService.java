package com.POC.User.Service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.POC.User.Entity.FeedbackUser;
import com.POC.User.Repository.FeedbackUserRepository;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	FeedbackUserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		FeedbackUser user = userRepo.findByEmailId(username)
				.orElseThrow(()-> new UsernameNotFoundException("User not found with username " +username));
		return new 	User(
				user.getEmailId(),
				user.getPassword(),
				Collections.singletonList(new SimpleGrantedAuthority(user.getRole()))
		);	
	}
}
