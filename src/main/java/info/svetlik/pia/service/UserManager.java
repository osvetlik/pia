package info.svetlik.pia.service;

import java.util.List;

import info.svetlik.pia.domain.User;

public interface UserManager {

	List<User> getUsers();

	void addUser(String username, String password);

}
