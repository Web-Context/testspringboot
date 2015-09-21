package com.webcontext.apps.sprintboot.controllers.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webcontext.apps.sprintboot.entities.User;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepository repo;

	@RequestMapping(method = RequestMethod.GET)
	public List<User> findUsers() {
		return repo.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable Integer id) {
		return repo.findOne(id);
	}

	@RequestMapping(value = "/search/{username}", method = RequestMethod.GET)
	public User findByUsername(@PathVariable String username) {
		return repo.findByUsername(username);
	}

	@RequestMapping(method = RequestMethod.POST)
	public User addItem(@RequestBody User item) {
		item.setId(null);
		return repo.saveAndFlush(item);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public User updateItem(@RequestBody User updatedItem,
			@PathVariable Integer id) {
		updatedItem.setId(id);
		return repo.saveAndFlush(updatedItem);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteItem(@PathVariable Integer id) {
		repo.delete(id);
	}
}