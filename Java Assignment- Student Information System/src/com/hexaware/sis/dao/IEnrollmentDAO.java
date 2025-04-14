package com.hexaware.sis.dao;

import com.hexaware.sis.entity.Enrollment;
import java.util.List;

public interface IEnrollmentDAO {
    void addEnrollment(Enrollment enrollment) throws Exception;
    List<Enrollment> getEnrollmentsByStudentId(int studentId) throws Exception;
    List<Enrollment> getEnrollmentsByCourseId(int courseId) throws Exception;
}

