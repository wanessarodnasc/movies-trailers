package br.letsmovie.task.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.letsmovie.task.model.User;
import br.letsmovie.task.repository.UserRepository;

/**
* 
* @author Wanessa Nascimento
*
*/
@Service
public class AutenticationService implements UserDetailsService {
	
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		Optional<User> user = repository.findByEmail(username);
		if (user.isPresent()) {
			return user.get();
		}
		throw new UsernameNotFoundException("Bad credentials.");
	}
}
