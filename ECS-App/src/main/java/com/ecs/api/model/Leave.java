package com.ecs.api.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "leave_details")
public class Leave {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private LocalDate fromDate;
	private LocalDate toDate;
	private Long numDays;
	private LocalDate appliedAt; 
	private String status; //{PENDING, APPROVED, DENIED}
	
	@OneToOne
	private Employee employee;

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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
