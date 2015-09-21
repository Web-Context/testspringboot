package com.webcontext.apps.sprintboot.controllers.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.webcontext.apps.sprintboot.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByLastName(@Param("lastname") String lastname);

	List<User> findByEmail(@Param("email") String email);

	User findByUsername(String username);

}