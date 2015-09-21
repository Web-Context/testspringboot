package com.webcontext.apps.sprintboot.controllers.item;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webcontext.apps.sprintboot.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}