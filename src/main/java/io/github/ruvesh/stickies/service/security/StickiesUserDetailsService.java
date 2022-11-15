package io.github.ruvesh.stickies.service.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.github.ruvesh.stickies.model.User;
import io.github.ruvesh.stickies.repository.UserRepository;

@Service
public class StickiesUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException(username));
		return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), new ArrayList<>());
	}

}
