package com.ecs.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecs.api.model.Leave;

public interface LeaveRepository extends JpaRepository<Leave, Long> {

	@Query("select l from Leave l where l.isArchived=?2 and l.employee.user.username=?1")
	List<Leave> getLeavesByEmployeeUsername(String username, boolean isArchived);

}
