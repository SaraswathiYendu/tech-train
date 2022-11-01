package com.ecs.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecs.api.model.Leave;

public interface LeaveRepository extends JpaRepository<Leave, Long> {

}
