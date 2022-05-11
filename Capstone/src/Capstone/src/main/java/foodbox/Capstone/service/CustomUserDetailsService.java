package foodbox.Capstone.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import foodbox.Capstone.model.CustomUserDetail;
import foodbox.Capstone.model.User;
import foodbox.Capstone.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
     @Autowired
     private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findUserByEmail(email);
		user.orElseThrow(()-> new UsernameNotFoundException("user not deteted"));
		return user.map(CustomUserDetail::new).get();
	}
 
}
