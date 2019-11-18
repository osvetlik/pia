package info.svetlik.pia.service;

import java.util.List;

import info.svetlik.pia.domain.Role;

public interface RoleManager {

	List<Role> getRoles();

	void addRole(String code, String name);

}
