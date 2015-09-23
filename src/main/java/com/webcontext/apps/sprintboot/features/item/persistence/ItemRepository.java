package com.webcontext.apps.sprintboot.features.item.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}