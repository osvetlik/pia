package info.svetlik.pia.service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import info.svetlik.pia.dao.UserRepository;
import info.svetlik.pia.domain.User;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserManagerImpl implements UserManager {

	private static final String DEFAULT_USER = "admin";
	private static final String DEFAULT_PASSWORD = "default";

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

	@Lazy(false)
	@EventListener(classes = {ContextRefreshedEvent.class})
	public void setup() {
		if (this.repo.count() == 0) {
			log.info("No user present, creating admin.");
			this.addUser(DEFAULT_USER, DEFAULT_PASSWORD);
		}
	}

}
