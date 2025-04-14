package com.hexaware.sis.entity;

import java.util.ArrayList;
import java.util.List;

public class Teacher {

    private int teacherId;
    private String firstName;
    private String lastName;
    private String email;

    private List<Course> assignedCourses = new ArrayList<>();  // List of courses assigned to this teacher

    public Teacher() {
    }

    public Teacher(int teacherId, String firstName, String lastName, String email) {
        this.teacherId = teacherId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

   
    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Method to update teacher information
    public void updateTeacherInfo(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Method to display teacher information
    public void displayTeacherInfo() {
        System.out.println("Teacher ID: " + teacherId);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Email: " + email);
    }

    // Method to assign a course to this teacher
    public void assignCourse(Course course) {
        assignedCourses.add(course);
    }

    // Method to get all assigned courses for this teacher
    public List<Course> getAssignedCourses() {
        return assignedCourses;
    }

    // Method to get full name of the teacher
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Teacher [teacherId=" + teacherId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
    }
}
