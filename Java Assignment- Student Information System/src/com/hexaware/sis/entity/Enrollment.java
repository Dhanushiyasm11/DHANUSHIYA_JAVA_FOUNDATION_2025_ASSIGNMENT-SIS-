package com.hexaware.sis.entity;

public class Enrollment {

    private int enrollmentId;
    private Student student;
    private Course course;
    private String enrollmentDate;

   
    public Enrollment() {
    }

  
    public Enrollment(int enrollmentId, Student student, Course course, String enrollmentDate) {
        this.enrollmentId = enrollmentId;
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
    }


    public int getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(int enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    // Method to retrieve the student associated with this enrollment
    public Student getStudentInfo() {
        return this.student;
    }

    // Method to retrieve the course associated with this enrollment
    public Course getCourseInfo() {
        return this.course;
    }

    // Method to display enrollment information
    public void displayEnrollmentInfo() {
        System.out.println("Enrollment ID: " + enrollmentId);
        System.out.println("Student: " + student.getFirstName() + " " + student.getLastName());
        System.out.println("Course: " + course.getCourseName());
        System.out.println("Enrollment Date: " + enrollmentDate);
    }

    @Override
    public String toString() {
        return "Enrollment [enrollmentId=" + enrollmentId + ", student=" + student + ", course=" + course
                + ", enrollmentDate=" + enrollmentDate + "]";
    }
}

