package com.hexaware.sis.service;

import com.hexaware.sis.entity.Teacher;
import java.util.List;

public interface ITeacherService {
    void addTeacher(Teacher teacher) throws Exception;
    Teacher getTeacherById(int teacherId) throws Exception;
    List<Teacher> getAllTeachers() throws Exception;
}
