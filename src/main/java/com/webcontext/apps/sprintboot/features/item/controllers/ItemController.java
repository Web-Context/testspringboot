package com.webcontext.apps.sprintboot.features.item.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webcontext.apps.sprintboot.core.model.SuperEntity;
import com.webcontext.apps.sprintboot.features.item.persistence.Item;
import com.webcontext.apps.sprintboot.features.item.persistence.ItemRepository;

@RestController
@RequestMapping("/items")
public class ItemController {
	@Autowired
	private ItemRepository repo;

	@RequestMapping(method = RequestMethod.GET)
	public List<Item> findItems() {
		return repo.findAll();
	}

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public SuperEntity findById(@PathVariable Integer id) {
		return repo.findOne(id);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public SuperEntity addItem( @RequestBody Item item ) {
		item.setId(null);
		return repo.saveAndFlush(item);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public SuperEntity updateItem( @RequestBody Item updatedItem, @PathVariable Integer id ) {
		updatedItem.setId(id);
		return repo.saveAndFlush(updatedItem);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteItem( @PathVariable Integer id ) {
		repo.delete(id);
	}
}