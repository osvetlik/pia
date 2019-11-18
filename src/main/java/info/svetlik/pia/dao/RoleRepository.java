package info.svetlik.pia.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import info.svetlik.pia.domain.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

	Role findByCode(String code);

}
