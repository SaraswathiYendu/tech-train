package com.springboot.api.dto;

import java.util.Arrays;
import java.util.List;

public class InstructorCourseDto {
	private Long instructorId;
	private List<Long> courseIds;
	private String year;

	public Long getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(Long instructorId) {
		this.instructorId = instructorId;
	}

	public List<Long> getCourseIds() {
		return courseIds;
	}

	public void setCourseIds(List<Long> courseIds) {
		this.courseIds = courseIds;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "InstructorCourseDto [instructorId=" + instructorId + ", courseIds=" + courseIds + ", year=" + year
				+ "]";
	}
 
	
}
