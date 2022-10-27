package com.ecs.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecs.api.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
