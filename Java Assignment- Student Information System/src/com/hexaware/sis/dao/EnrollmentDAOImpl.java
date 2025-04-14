package com.hexaware.sis.dao;

import com.hexaware.sis.entity.Enrollment;
import com.hexaware.sis.util.DBConnUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentDAOImpl implements IEnrollmentDAO {

    @Override
    public void addEnrollment(Enrollment enrollment) throws Exception {
        String sql = "INSERT INTO enrollments (student_id, course_id, enrollment_date) VALUES (?, ?, ?)";
        try (Connection con = DBConnUtil.getConnection("db.properties");
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, enrollment.getStudent().getStudentId());
            ps.setInt(2, enrollment.getCourse().getCourseId());
            ps.setString(3, enrollment.getEnrollmentDate());

            ps.executeUpdate();  
        }
    }

    @Override
    public List<Enrollment> getEnrollmentsByStudentId(int studentId) throws Exception {
        List<Enrollment> list = new ArrayList<>();
        String sql = "SELECT * FROM enrollments WHERE student_id = ?";
        try (Connection con = DBConnUtil.getConnection("db.properties");
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Enrollment(
                        rs.getInt("enrollment_id"),
                        new StudentDAOImpl().getStudentById(rs.getInt("student_id")),
                        new CourseDAOImpl().getCourseById(rs.getInt("course_id")),
                        rs.getString("enrollment_date")
                ));
            }
        }
        return list;
    }

	@Override
	public List<Enrollment> getEnrollmentsByCourseId(int courseId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}

