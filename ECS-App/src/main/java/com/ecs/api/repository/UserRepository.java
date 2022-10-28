package com.ecs.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecs.api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("select u from User u where u.username=?1")
	User getUserByUsername(String username);

}
/* 
 select u from User u where u.username='harry@gmail.com';
 */
