package com.ecs.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecs.api.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	@Query("select e from Employee e where e.manager.user.username=?1 "
			+ " AND e.user.isEnabled=?2")
	List<Employee> getEmployeesByManagerUser(String managerUsername, boolean enabled);

}
