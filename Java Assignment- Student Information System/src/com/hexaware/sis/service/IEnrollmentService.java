package com.hexaware.sis.service;

import com.hexaware.sis.entity.Enrollment;
import java.util.List;

public interface IEnrollmentService {
    void enrollStudent(Enrollment enrollment) throws Exception;
    List<Enrollment> getEnrollmentsByStudentId(int studentId) throws Exception;
    List<Enrollment> getEnrollmentsByCourseId(int courseId) throws Exception;
	void addEnrollment(Enrollment enrollment);
}
