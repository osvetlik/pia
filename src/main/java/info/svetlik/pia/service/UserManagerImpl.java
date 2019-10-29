package info.svetlik.pia.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import info.svetlik.pia.domain.User;

@Service
public class UserManagerImpl implements UserManager, UserDetailsService {

	private final Map<String, User> users = new HashMap<>();

	private final PasswordEncoder encoder;

	@Autowired
	public UserManagerImpl(PasswordEncoder encoder) {
		this.encoder = encoder;
	}

	@Override
	public List<User> getUsers() {
		return Collections.unmodifiableList(new LinkedList<>(users.values()));
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		if (!this.users.containsKey(username)) {
			throw new UsernameNotFoundException("User does not exist!");
		}
		return this.users.get(username);
	}

	@Override
	public void addUser(String username, String password) {
		if (this.users.containsKey(username)) {
			throw new IllegalArgumentException("User already exists!");
		}

		String hashed = this.encoder.encode(password);
		User user = new User(username, hashed);
		this.users.put(username, user);
	}

}
