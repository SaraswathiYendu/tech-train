package com.ecs.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecs.api.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{

}
