package com.ecs.api.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ecs.api.model.Ticket;

public class ResTicketDto {
	private Long id;
	private String issue;
	private String priority; // {RED,BLUE,YELLOW}
	private LocalDate createdAt;
	private String response; // varchar(255)
	private String status; // {OPEN,CLOSE}
	private String name;
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static List<ResTicketDto> convertToDto(List<Ticket> list){
		List<ResTicketDto> listDto = new ArrayList<>();
		for(Ticket t : list) {
			ResTicketDto dto = new ResTicketDto();
			dto.setId(t.getId());
			dto.setIssue(t.getIssue());
			dto.setPriority(t.getPriority());
			dto.setResponse(t.getResponse());
			dto.setStatus(t.getStatus());
			dto.setCreatedAt(t.getCreatedAt());
			dto.setEmail(t.getEmployee().getUser().getUsername());
			dto.setName(t.getEmployee().getName());
			listDto.add(dto);
		}
			return listDto;
	}
}
