package com.hexaware.sis.dao;

import com.hexaware.sis.entity.Student;
import java.util.List;

public interface IStudentDAO {
    void addStudent(Student student) throws Exception;
    Student getStudentById(int studentId) throws Exception;
    List<Student> getAllStudents() throws Exception;
}
