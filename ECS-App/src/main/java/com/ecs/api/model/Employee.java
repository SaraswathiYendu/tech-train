package com.ecs.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String jobTitle; 
	
	@OneToOne
	private User user;
	
	@OneToOne
	private Manager manager;

	/*
	 id: --,
	 name: --,
	 jobTitle: --,
	 user:{
	 	id: --
	 	username: --
	 	password: --
	 	role: --
	 },
	 manager:{
	 	id: 
	 	
	 }
	 --------------
	 id: --,
	 name: --,
	 jobTitle: --,
	 username: --,
	 password: --
	 
	 */
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", jobTitle=" + jobTitle + ", user=" + user + ", manager="
				+ manager + "]";
	}
	
	
}
