package com.hexaware.sis.dao;

import com.hexaware.sis.entity.Course;
import com.hexaware.sis.util.DBConnUtil;

import java.sql.*;
import java.util.*;

public class CourseDAOImpl implements ICourseDAO {

    @Override
    public void addCourse(Course course) throws Exception {
       
        String sql = "INSERT INTO courses (course_id, course_name, credits, teacher_id) VALUES (?, ?, ?, ?)";
        try (Connection con = DBConnUtil.getConnection("db.properties");
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, course.getCourseId());  // course_id
            ps.setString(2, course.getCourseName());  // course_name
            ps.setInt(3, course.getCredits());  // credits
            ps.setInt(4, course.getTeacherId());  // teacher_id

            ps.executeUpdate();  // Executes the insertion query
        }
    }

    @Override
    public Course getCourseById(int courseId) throws Exception {
        String sql = "SELECT * FROM courses WHERE course_id = ?";
        try (Connection con = DBConnUtil.getConnection("db.properties");
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, courseId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Course(
                        rs.getInt("course_id"),
                        rs.getString("course_name"),
                        rs.getInt("credits"),
                        rs.getInt("teacher_id")
                );
            }
        }
        return null;
    }

    @Override
    public List<Course> getAllCourses() throws Exception {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT * FROM courses";
        try (Connection con = DBConnUtil.getConnection("db.properties");
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Course(
                        rs.getInt("course_id"),
                        rs.getString("course_name"),
                        rs.getInt("credits"),
                        rs.getInt("teacher_id")
                ));
            }
        }
        return list;
    }
}
