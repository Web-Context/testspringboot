package com.webcontext.apps.mcgapp.features.user.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webcontext.apps.mcgapp.features.user.persistence.User;
import com.webcontext.apps.mcgapp.features.user.persistence.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepository userRepo;

	@RequestMapping(method = RequestMethod.GET)
	public List<User> findUsers() {
		return userRepo.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable Integer id) {
		return userRepo.findOne(id);
	}

	@RequestMapping(value = "/search/{username}", method = RequestMethod.GET)
	public User findByUsername(@PathVariable String username) {
		return userRepo.findByUsername(username);
	}

	@RequestMapping(method = RequestMethod.POST)
	public User addItem(@RequestBody User item) {
		item.setId(null);
		return userRepo.saveAndFlush(item);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public User updateItem(@RequestBody User updatedItem,
			@PathVariable Integer id) {
		updatedItem.setId(id);
		return userRepo.saveAndFlush(updatedItem);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteItem(@PathVariable Integer id) {
		userRepo.delete(id);
	}
}