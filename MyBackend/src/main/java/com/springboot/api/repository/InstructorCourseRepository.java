package com.springboot.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.api.model.InstructorCourse;

public interface InstructorCourseRepository extends JpaRepository<InstructorCourse, Long>{

	@Query("select ic from InstructorCourse ic"
			+ " where ic.instructor.id=?1 AND "
			+ " ic.course.id=?2 AND "
			+ " ic.year=?3")
	InstructorCourse validate(Long instructorID, Long courseId, String year);

}
