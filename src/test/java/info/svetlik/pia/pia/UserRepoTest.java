package info.svetlik.pia.pia;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import info.svetlik.pia.dao.UserRepository;
import info.svetlik.pia.domain.User;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class UserRepoTest {

	@Autowired
	private UserRepository userRepo;

	@Test
	@Transactional
	public void testUserManipulation() {
		log.info("Testing user manipulation.");
		Assertions.assertEquals(1, userRepo.count());
		log.info("Looking for admin.");
		User user = userRepo.findByUsername("admin");
		Assertions.assertNotNull(user);
		log.info("Found admin.");
		Assertions.assertEquals(1, user.getRoles().size());
		log.info("Admin has one role, removing.");
		user.getRoles().remove(0);
		userRepo.save(user);
		user = userRepo.findByUsername("admin");
		Assertions.assertEquals(0, user.getRoles().size());
		log.info("Admin has no role now, OK.");
	}

}
