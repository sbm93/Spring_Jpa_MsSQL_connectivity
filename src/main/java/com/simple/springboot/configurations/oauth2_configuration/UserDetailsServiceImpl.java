package com.simple.springboot.configurations.oauth2_configuration;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simple.springboot.Repositories.UserRepository;
import com.simple.springboot.models.User;

@Service("customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		if (user == null) {
            // Not found...
            throw new UsernameNotFoundException(
                    "User email " + email + " not found.");
        }
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), 
                true, true, true, true, grantedAuthorities);
	}

}
