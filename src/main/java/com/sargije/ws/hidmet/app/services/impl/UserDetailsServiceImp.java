package com.sargije.ws.hidmet.app.services.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sargije.ws.hidmet.app.model.Authorities;
import com.sargije.ws.hidmet.app.model.Users;
import com.sargije.ws.hidmet.app.repository.UsersRepository;

@Service("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService {
	
	@Autowired
	UsersRepository usersRepository;
	
	@SuppressWarnings("unchecked")
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Users user = usersRepository.findOne(username);

		/*UserBuilder builder = null;
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
		}*/
		 
		 /**
		  * 
		  * authorities = new HashSet<GrantedAuthority>(roles.size());

			for (String role : roles)
			    authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
		  */

		 Stream<Object> myNewStream = user.getAuthoritieses().stream().map(s -> 
		 								new SimpleGrantedAuthority(s.getId().getAuthority()));
		 
		 return new User(
              username, user.getPassword(), user.isEnabled(), true, true, true, 
              (Collection<? extends GrantedAuthority>) Arrays.asList(myNewStream.toArray()));
		
	}

}
