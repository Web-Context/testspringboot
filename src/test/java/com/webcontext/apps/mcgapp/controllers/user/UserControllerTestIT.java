/**
 * file: UserControllerTestIT.java
 * date: 25 sept. 2015
 *
 * GEHC DoseWatch
 *
 * Copyright (c) 2015 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 *
 */

package com.webcontext.apps.mcgapp.controllers.user;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;

import java.util.Arrays;

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
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jayway.restassured.RestAssured;
import com.webcontext.apps.mcgapp.Application;
import com.webcontext.apps.mcgapp.features.user.persistence.User;
import com.webcontext.apps.mcgapp.features.user.persistence.UserRepository;

/**
 * @author 212391884
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port=0")
public class UserControllerTestIT {
	@Autowired
	UserRepository userRepo;
	
	
	@Autowired
	private ApplicationContext context;
	
	Authentication authentication;
	
	User user1;
	User user2;
	User user3;

	@Value("${local.server.port}")
	int port;

	@Before
	public void setup() {
		user1 = new User("user01", "pass", "user01@email.com", "user1", "01");
		user2 = new User("user02", "pass", "user02@email.com", "user2", "02");
		user3 = new User("user03", "pass", "user03@email.com", "user3", "03");
		userRepo.deleteAll();
		userRepo.save(Arrays.asList(user1, user2, user3));

		RestAssured.port = port;
		
		AuthenticationManager authenticationManager = this.context
				.getBean(AuthenticationManager.class);
		this.authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken("user", "password"));
		
		
	}

	@After
	public void clearall() {
		userRepo.deleteAll();
	}

	@Test
	public void canFetchUser1() {
		Integer user01Id = user1.getId();
		SecurityContextHolder.getContext().setAuthentication(this.authentication);
		
		
		given()
			.auth()
				.basic("user","password")
		.when()
			.get("/users/{id}", user01Id)
			.then()
				.statusCode(HttpStatus.SC_OK)
				.body("firstName", Matchers.is("user1"))
				.body("id", Matchers.is(user01Id));
	}

	@Test
	public void canFetchUser1ByEmail() {
		SecurityContextHolder.getContext().setAuthentication(this.authentication);
		
		
		given()
			.auth()
				.basic("user","password")
		.when()
			.get("/users/searchmail/{email}", user1.getEmail())
			.then()
				.statusCode(HttpStatus.SC_OK)
				.body("email", Matchers.is("user1"))
				.body("id", Matchers.is(user1.getEmail()));
	}
	
}
