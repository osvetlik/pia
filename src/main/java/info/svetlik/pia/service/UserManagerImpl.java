package info.svetlik.pia.service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import info.svetlik.pia.dao.UserRepository;
import info.svetlik.pia.domain.User;

@Service
public class UserManagerImpl implements UserManager {

	private final PasswordEncoder encoder;

	private final UserRepository repo;

	@Autowired
	public UserManagerImpl(PasswordEncoder encoder, UserRepository repo) {
		this.encoder = encoder;
		this.repo = repo;
	}

	@Override
	public List<User> getUsers() {
		List<User> retVal = new LinkedList<>();
		for (User user : this.repo.findAll()) {
			retVal.add(user);
		}
		return Collections.unmodifiableList(retVal);
	}

	@Override
	public void addUser(String username, String password) {
		if (this.repo.findByUsername(username) != null) {
			throw new IllegalArgumentException("User already exists!");
		}

		String hashed = this.encoder.encode(password);
		User user = new User(username, hashed);
		this.repo.save(user);
	}

}
