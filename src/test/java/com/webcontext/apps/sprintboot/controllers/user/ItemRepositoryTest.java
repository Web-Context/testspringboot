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
import com.webcontext.apps.sprintboot.controllers.item.ItemRepository;
import com.webcontext.apps.sprintboot.entities.Item;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class ItemRepositoryTest {

	@Autowired
	ItemRepository repo;

	@Test
	public void testFindAll() {
		Item item1 = new Item(true, "Test 1");
		Item item2 = new Item(true, "Test 2");
		Item item3 = new Item(true, "Test 3");
		repo.save(item1);
		repo.save(item2);
		repo.save(item3);
		List<Item> items = repo.findAll();
		assertEquals("Unable to retrieve items", 3, items.size());
	}

	@Test
	public void testSaveS() {
		Item item = new Item(true, "Test 1");
		repo.save(item);
		assertEquals("Unable to save item", true, item.getId() != null);
	}

	@Test
	public void testDeleteT() {
		Item item1 = new Item(true, "Test 1");
		Item item2 = new Item(true, "Test 2");
		repo.save(item1);
		repo.save(item2);
		int item2Id = item2.getId();

		repo.delete(item2);

		Item itemFind = repo.findOne(item2Id);

		assertEquals("Unable to save item", null, itemFind);

	}

}
