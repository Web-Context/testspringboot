package com.webcontext.apps.sprintboot.controllers.user;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webcontext.apps.sprintboot.Application;
import com.webcontext.apps.sprintboot.features.user.persistence.User;
import com.webcontext.apps.sprintboot.features.user.persistence.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class UserRepositoryTest {

	@Autowired
	UserRepository repo;

	@Test
	public void testFindByLastName() {
		User user = new User("user01", "password", "my.mail@server.com",
				"firstname", "lastname");
		repo.save(user);
		assertEquals("unable to create user", true, user.getId() != null);
	}

	@Test
	public void testFindByEmail() {
		User user = new User("user02", "password", "my.mail2@server.com",
				"firstname", "lastname");
		repo.save(user);
		List<User> userFound = repo.findByEmail("my.mail2@server.com");
		assertEquals("Can not retrieve the user with email" + user.getEmail(),
				user.getEmail(), userFound.get(0).getEmail());
	}

	@Test
	public void testFindByUsername() {
		User user = new User("user03", "password", "my.mail3@server.com",
				"firstname", "lastname");
		repo.save(user);
		User userFound = repo.findByUsername("user03");
		assertEquals("Can not retrieve the user with email" + user.getEmail(),
				user.getUsername(), userFound.getUsername());
	}

}
