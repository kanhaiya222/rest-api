package com.restapi.restapi.services;

import java.util.List;

import com.restapi.restapi.Model.Course;

public interface CourseService {
	
	public List<Course> getCourses();
	
	public Course getCourse(long courseId);
	
	public Course addCourses(Course course);

	public Course updateCourse(Course course);
	
	public void deleteCourse(long courseId);
}
