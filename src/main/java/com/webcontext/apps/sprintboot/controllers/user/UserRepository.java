package com.webcontext.apps.sprintboot.controllers.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.webcontext.apps.sprintboot.entities.User;

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByLastName(@Param("name") String name);

}