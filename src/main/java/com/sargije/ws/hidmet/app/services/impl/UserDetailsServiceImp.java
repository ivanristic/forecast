package com.sargije.ws.hidmet.app.services.impl;

import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sargije.ws.hidmet.app.model.Authorities;
import com.sargije.ws.hidmet.app.model.Users;
import com.sargije.ws.hidmet.app.repository.UsersRepository;

@Service("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService {
	
	@Autowired
	UsersRepository usersRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Users user = usersRepository.findOne(username);
		
		UserBuilder builder = null;
		if (user != null) {
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			//builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
			builder.password(user.getPassword());
			builder.accountExpired(!user.isEnabled());
//			Iterator iterator =  user.getAuthoritieses().iterator();
//			while(iterator.hasNext()){
//				Authorities element = (Authorities) iterator.next();
//				}
//			
			String[] authorities = {"ADMIN"};

			builder.roles(authorities);
		} else {
			throw new UsernameNotFoundException("User not found.");
		}

		return builder.build();
	}

}
