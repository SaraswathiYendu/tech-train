package com.ecs.api.dto;

import java.util.ArrayList;
import java.util.List;

import com.ecs.api.model.Employee;

public class ReqEmployeeDto {
	private Long id;
	private String name;
	private String jobTitle;
	private String username;
	private String password;

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

	public static List<ReqEmployeeDto> convert(List<Employee> list){
		List<ReqEmployeeDto> listDto = new ArrayList<>();
		for(Employee e:list) {
			ReqEmployeeDto dto = new ReqEmployeeDto();
			dto.setId(e.getId());
			dto.setJobTitle(e.getJobTitle());
			dto.setName(e.getName());
			dto.setUsername(e.getUser().getUsername());
			listDto.add(dto);
		}
		return listDto;
	}
}
