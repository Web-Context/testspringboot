package com.webcontext.apps.mcgapp.features.item.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}