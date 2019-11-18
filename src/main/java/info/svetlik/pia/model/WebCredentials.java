package info.svetlik.pia.model;

import java.util.Collection;
import java.util.LinkedList;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class WebCredentials implements UserDetails {

	private static final long serialVersionUID = 26298569253774237L;

	private final String username;
	private final String password;
	private Collection<String> roles;

	public WebCredentials(String username, String password) {
		this.username = username;
		this.password = password;
		this.roles = new LinkedList<>();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles
		.stream()
		.map(SimpleGrantedAuthority::new)
		.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public void addRole(String role) {
		this.roles.add(role);
	}

}
