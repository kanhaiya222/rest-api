package com.restapi.restapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.restapi.restapi.Model.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	List<Course> list;
	
	public CourseServiceImpl() {
		list = new ArrayList<>();
		list.add( new Course(1,"java","learning java"));
		list.add( new Course(2,"spring","learning spring boot"));
	}

	@Override
	public List<Course> getCourses() {
		return list;
	}

	@Override
	public Course getCourse(long courseId) {
		
		Course c = null;
		for(Course course:list) {
			if(course.getId()== courseId) {
				c = course;
				break;
			}
		}
		return c;
	}

	@Override
	public Course addCourses(Course course) {
		list.add(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		list.forEach(e -> {
			if(e.getId() == course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescrption(course.getDescrption());
			}
		});
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
		list = this.list.stream().filter(e-> e.getId() != parseLong).collect(Collectors.toList());
	}

}
