package com.webcontext.apps.mcgapp.controllers.user;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webcontext.apps.mcgapp.Application;
import com.webcontext.apps.mcgapp.features.user.persistence.User;
import com.webcontext.apps.mcgapp.features.user.persistence.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class UserRepositoryTest {

	@Autowired
	UserRepository userRepo;

	User user1;
	User user2;
	User user3;

	@Before
	public void setup() {
		user1 = new User("user01", "pass1234", "user01@email.com", "user1", "01");
		user2 = new User("user02", "pass1234", "user02@email.com", "user2", "02");
		user3 = new User("user03", "pass1234", "user03@email.com", "user3", "03");
		userRepo.deleteAll();
		List<User> users = Arrays.asList(user1, user2, user3);
		userRepo.save(users);
	}

	@After
	public void clearall() {
		userRepo.deleteAll();
	}

	@Test
	public void testFindByLastName() {
		assertEquals("unable to create user", true, user1.getId() != null);
	}

	@Test
	public void testFindByEmail() {
		List<User> userFound = userRepo.findByEmail("user02@email.com");
		assertEquals("Can not retrieve the user with email" + user2.getEmail(), user2.getEmail(), userFound.get(0)
				.getEmail());
	}

	@Test
	public void testFindByUsername() {
		User userFound = userRepo.findByUsername("user03");
		assertEquals("Can not retrieve the user with email" + user3.getEmail(), user3.getUsername(),
				userFound.getUsername());
	}
}
