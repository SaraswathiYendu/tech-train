package com.ecs.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecs.api.model.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Long>{
	
	@Query("select m from Manager m where m.user.username=?1")
	Manager getByUsername(String username);

}
