package com.springboot.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.api.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);

	 

}
