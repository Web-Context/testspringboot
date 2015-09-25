package com.webcontext.apps.sprintboot.controllers.user;

import static com.jayway.restassured.RestAssured.when;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jayway.restassured.RestAssured;
import com.webcontext.apps.mcgapp.Application;
import com.webcontext.apps.mcgapp.features.user.persistence.User;
import com.webcontext.apps.mcgapp.features.user.persistence.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port=0")
public class UserRepositoryTest {

	@Autowired
	UserRepository userRepo;

	User user1;
	User user2;
	User user3;

	@Value("${local.server.port}")
	int port;

	@Before
	public void setup() {
		user1 = new User("user01", "pass", "user01@email.com", "user1", "01");
		user1 = new User("user02", "pass", "user02@email.com", "user2", "02");
		user1 = new User("user03", "pass", "user03@email.com", "user3", "03");
		userRepo.deleteAll();
		userRepo.save(Arrays.asList(user1, user2, user3));

		RestAssured.port = port;
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

	@Test
	public void canFetchUser1() {
		Integer user01Id = user1.getId();

		when()
		.get("/users/{id}", user01Id)
		.then()
			.statusCode(HttpStatus.SC_OK)
			.body("firstname", Matchers.is("user1"))
			.body("id", Matchers.is(user01Id));
	}

}
