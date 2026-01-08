package app.portfolio.service;

import java.util.ArrayList;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService{
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	if (System.getenv("USER").equals(username)) {
            return new User(System.getenv("USER"), System.getenv("PASSWORD"), new ArrayList<>());
	} else {
            throw new UsernameNotFoundException("User not found with username: " + username);
	}
    }
}
