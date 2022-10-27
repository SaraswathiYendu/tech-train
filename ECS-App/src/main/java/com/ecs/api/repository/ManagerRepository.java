package com.ecs.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecs.api.model.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Long>{

}
