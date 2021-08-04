package com.levimartines.hrauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.levimartines.hrauth.feignclients.UserFeignClient;
import com.levimartines.hrauth.models.User;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserFeignClient userFeignClient;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userFeignClient.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("Email not found");
		}
		return user;
	}
}
