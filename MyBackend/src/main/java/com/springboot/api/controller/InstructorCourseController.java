package com.springboot.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.dto.InstructorCourseDto;
import com.springboot.api.model.Course;
import com.springboot.api.model.Instructor;
import com.springboot.api.model.InstructorCourse;
import com.springboot.api.repository.CourseRepository;
import com.springboot.api.repository.InstructorCourseRepository;
import com.springboot.api.repository.InstructorRepository;

@RestController
public class InstructorCourseController {

	@Autowired
	private InstructorCourseRepository instructorCourseRepository;
	@Autowired
	private InstructorRepository instructorRepository;
	@Autowired
	private CourseRepository courseRepository; 
	
	@PostMapping("/instructor/course/assign/multiple")
	public void assignInstructorToCourse(@RequestBody InstructorCourseDto dto) {
		System.out.println(dto); //InstructorCourseDto [instructorId=2, courseIds=[1, 3, 7], year=2022]
		List<InstructorCourse> list = new ArrayList<>();
		/* Get Instructor Details */
		Optional<Instructor> optional = instructorRepository.findById(dto.getInstructorId());
		if(!optional.isPresent())
				throw new RuntimeException("Instructor ID Invalid"); 	
	
		Instructor instructor = optional.get();
		
		dto.getCourseIds().stream().forEach(id->{   //1 3 7 
			InstructorCourse ic = new InstructorCourse();
			 ic.setInstructor(instructor);
			 
			 /* Get Course Details */
			 Optional<Course> optionalc = courseRepository.findById(id);
			 if(!optionalc.isPresent())
				 throw new RuntimeException("Course ID Invalid: " + id); 
			 Course course = optionalc.get();
			 
			 /* Set Details in ic */
			 ic.setCourse(course);
			 ic.setYear(dto.getYear());
			 
			 /* Validate this entry if present in DB */
			 InstructorCourse icDB = instructorCourseRepository.validate(instructor.getId(),course.getId(),dto.getYear());
			 
			 if(icDB == null)
				 list.add(ic);
			  
		});
		
		instructorCourseRepository.saveAll(list);
	}
}
