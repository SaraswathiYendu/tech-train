package com.ecs.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecs.api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
