package com.ecs.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecs.api.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{

	@Query("select t from Ticket t where t.status=?2 AND t.employee.user.username=?1")
	List<Ticket> getTicketByEmployeeUsername(String username, String status);

}
