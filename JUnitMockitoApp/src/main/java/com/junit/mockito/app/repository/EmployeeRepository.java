package com.junit.mockito.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.junit.mockito.app.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
