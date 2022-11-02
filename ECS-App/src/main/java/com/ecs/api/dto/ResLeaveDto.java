package com.ecs.api.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ecs.api.model.Leave;

public class ResLeaveDto {
	private Long id;
	private LocalDate fromDate;
	private LocalDate toDate;
	private Long numDays;
	private LocalDate appliedAt;
	private String status; // {PENDING, APPROVED, DENIED}
	private Boolean isArchived; // {TRUE,FALSE}
	private String employeeName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public Long getNumDays() {
		return numDays;
	}

	public void setNumDays(Long numDays) {
		this.numDays = numDays;
	}

	public LocalDate getAppliedAt() {
		return appliedAt;
	}

	public void setAppliedAt(LocalDate appliedAt) {
		this.appliedAt = appliedAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getIsArchived() {
		return isArchived;
	}

	public void setIsArchived(Boolean isArchived) {
		this.isArchived = isArchived;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public static List<ResLeaveDto> convertToDto(List<Leave> list) {
		List<ResLeaveDto> listDto = new ArrayList<>();
		for(Leave l : list) {
			ResLeaveDto dto = new ResLeaveDto();
			dto.setId(l.getId());
			dto.setFromDate(l.getFromDate());
			dto.setToDate(l.getToDate());
			dto.setNumDays(l.getNumDays());
			dto.setIsArchived(l.getIsArchived());
			dto.setAppliedAt(l.getAppliedAt());
			dto.setStatus(l.getStatus());
			dto.setEmployeeName(l.getEmployee().getName());
			listDto.add(dto);
		}
		
		return listDto;
	}
}
