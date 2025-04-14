package com.hexaware.sis.dao;

import com.hexaware.sis.entity.Teacher;
import com.hexaware.sis.util.DBConnUtil;

import java.sql.*;
import java.util.List;

public class TeacherDAOImpl implements ITeacherDAO {

    @Override
    public void addTeacher(Teacher teacher) throws Exception {
        String sql = "INSERT INTO teachers (first_name, last_name, email) VALUES (?, ?, ?)";
        try (Connection con = DBConnUtil.getConnection("db.properties");
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, teacher.getFirstName());
            ps.setString(2, teacher.getLastName());
            ps.setString(3, teacher.getEmail());

            ps.executeUpdate();  
        }
    }

    @Override
    public Teacher getTeacherById(int teacherId) throws Exception {
        String sql = "SELECT * FROM teachers WHERE teacher_id = ?";
        try (Connection con = DBConnUtil.getConnection("db.properties");
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, teacherId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Teacher(
                        rs.getInt("teacher_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email")
                );
            }
        }
        return null;
    }

	@Override
	public List<Teacher> getAllTeachers() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}

