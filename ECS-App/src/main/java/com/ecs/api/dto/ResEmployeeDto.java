package com.ecs.api.dto;

import com.ecs.api.model.Employee;

public class ResEmployeeDto {
	private Long id;
	private String name;
	private String jobTitle;
	private String username;
	private String password;
	private String managerName;
	private int leavesLeft;
	private int totalLeaves;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public int getLeavesLeft() {
		return leavesLeft;
	}

	public void setLeavesLeft(int leavesLeft) {
		this.leavesLeft = leavesLeft;
	}

	public int getTotalLeaves() {
		return totalLeaves;
	}

	public void setTotalLeaves(int totalLeaves) {
		this.totalLeaves = totalLeaves;
	}

	public static ResEmployeeDto convertToEmployeeDto(Employee employee){
		ResEmployeeDto dto = new ResEmployeeDto();
		dto.setId(employee.getId());
		dto.setName(employee.getName());
		dto.setJobTitle(employee.getJobTitle());
		dto.setUsername(employee.getUser().getUsername());
		dto.setPassword("");
		dto.setManagerName(employee.getManager().getName());
		/* come back and leave info once created */
		return dto;
	}
}
