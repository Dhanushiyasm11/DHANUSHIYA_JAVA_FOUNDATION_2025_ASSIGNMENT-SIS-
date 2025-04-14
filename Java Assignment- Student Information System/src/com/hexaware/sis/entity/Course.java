package com.hexaware.sis.entity;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private int courseId;
    private String courseName;
    private int credits; 
    private int teacherId; 

    // List to hold all enrollments associated with this course
    private List<Enrollment> enrollments = new ArrayList<>();

 
    public Course() {
    }

  
    public Course(int courseId, String courseName, int credits, int teacherId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
        this.teacherId = teacherId;
    }

   
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    // Method to add an enrollment to the course
    public void addEnrollment(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    // Method to get all enrollments for the course
    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    // Method to display course information
    public void displayCourseInfo() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Course: " + courseName);
        System.out.println("Credits: " + credits);
        System.out.println("Teacher ID: " + teacherId);  
    }
}
