package com.hexaware.sis.service;

import com.hexaware.sis.dao.IEnrollmentDAO;
import com.hexaware.sis.dao.EnrollmentDAOImpl;
import com.hexaware.sis.entity.Enrollment;
import com.hexaware.sis.exception.DuplicateEnrollmentException;
import com.hexaware.sis.exception.InvalidEnrollmentDataException;

import java.util.List;

public class EnrollmentServiceImpl implements IEnrollmentService {
    private IEnrollmentDAO enrollmentDAO = new EnrollmentDAOImpl();

    @Override
    public void enrollStudent(Enrollment enrollment) throws Exception {
        if (enrollment.getStudent() == null || enrollment.getCourse() == null) {
            throw new InvalidEnrollmentDataException("Missing student or course.");
        }

        List<Enrollment> existing = enrollmentDAO.getEnrollmentsByStudentId(enrollment.getStudent().getStudentId());
        for (Enrollment e : existing) {
            if (e.getCourse().getCourseId() == enrollment.getCourse().getCourseId()) {
                throw new DuplicateEnrollmentException("Student already enrolled.");
            }
        }

        enrollmentDAO.addEnrollment(enrollment);
    }

    @Override
    public List<Enrollment> getEnrollmentsByStudentId(int studentId) throws Exception {
        return enrollmentDAO.getEnrollmentsByStudentId(studentId);
    }

    @Override
    public List<Enrollment> getEnrollmentsByCourseId(int courseId) throws Exception {
        return enrollmentDAO.getEnrollmentsByCourseId(courseId);
    }

	@Override
	public void addEnrollment(Enrollment enrollment) {
		// TODO Auto-generated method stub
		
	}
}

