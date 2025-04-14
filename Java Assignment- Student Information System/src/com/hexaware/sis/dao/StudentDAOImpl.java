package com.hexaware.sis.dao;

import com.hexaware.sis.entity.Student;
import com.hexaware.sis.util.DBConnUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements IStudentDAO {

    @Override
    public void addStudent(Student student) throws Exception {
        String sql = "INSERT INTO students (student_id, first_name, last_name, dob, email, phone_number) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = DBConnUtil.getConnection("db.properties");
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, student.getStudentId());
            ps.setString(2, student.getFirstName());
            ps.setString(3, student.getLastName());
            ps.setString(4, student.getDateOfBirth());
            ps.setString(5, student.getEmail());
            ps.setString(6, student.getPhoneNumber());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Student inserted into DB successfully.");
            }
        } catch (SQLException e) {
            System.out.println("DB Error while inserting student: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public Student getStudentById(int studentId) throws Exception {
        String sql = "SELECT * FROM students WHERE student_id = ?";
        try (Connection con = DBConnUtil.getConnection("db.properties");
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Student(
                    rs.getInt("student_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("dob"),
                    rs.getString("email"),
                    rs.getString("phone_number")
                );
            }
        }
        return null;
    }

    @Override
    public List<Student> getAllStudents() throws Exception {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection con = DBConnUtil.getConnection("db.properties");
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student student = new Student(
                    rs.getInt("student_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("dob"),
                    rs.getString("email"),
                    rs.getString("phone_number")
                );
                students.add(student);
            }
        }
        return students;
    }
}

