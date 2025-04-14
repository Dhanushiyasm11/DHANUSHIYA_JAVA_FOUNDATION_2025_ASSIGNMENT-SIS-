package com.hexaware.sis.service;

import com.hexaware.sis.dao.IStudentDAO;
import com.hexaware.sis.dao.StudentDAOImpl;
import com.hexaware.sis.entity.Student;
import com.hexaware.sis.exception.InvalidStudentDataException;
import com.hexaware.sis.exception.StudentNotFoundException;

import java.util.List;

public class StudentServiceImpl implements IStudentService {
    private IStudentDAO studentDAO = new StudentDAOImpl();

    @Override
    public void registerStudent(Student student) throws Exception {
        if (student.getEmail() == null || !student.getEmail().contains("@")) {
            throw new InvalidStudentDataException("Invalid email format.");
        }
        studentDAO.addStudent(student);
    }

    @Override
    public Student getStudentById(int studentId) throws Exception {
        Student student = studentDAO.getStudentById(studentId);
        if (student == null) {
            throw new StudentNotFoundException("Student not found.");
        }
        return student;
    }

    @Override
    public List<Student> getAllStudents() throws Exception {
        return studentDAO.getAllStudents();
    }
}

