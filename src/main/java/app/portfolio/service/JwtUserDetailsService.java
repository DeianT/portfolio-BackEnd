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
	if ("tezenaied@gmail.com".equals(username)) {
            return new User("tezenaied@gmail.com", "$2a$10$IBjLQW4t2jeN45vpJ02K2eqnPExauO7j3fn.JRIb6a4XMZjA2e6R2", new ArrayList<>());
	} else {
            throw new UsernameNotFoundException("User not found with username: " + username);
	}
    }
}
