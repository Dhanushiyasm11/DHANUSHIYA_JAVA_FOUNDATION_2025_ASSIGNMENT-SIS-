package com.hexaware.sis.service;

import com.hexaware.sis.entity.Course;
import java.util.List;

public interface ICourseService {
    void addCourse(Course course) throws Exception;
    Course getCourseById(int courseId) throws Exception;
    List<Course> getAllCourses() throws Exception;
	void updateCourse(Course course);
}
