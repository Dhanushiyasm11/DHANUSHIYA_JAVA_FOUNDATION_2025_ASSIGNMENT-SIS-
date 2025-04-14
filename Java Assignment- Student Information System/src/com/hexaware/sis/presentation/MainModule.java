package com.hexaware.sis.presentation;

import com.hexaware.sis.entity.*;
import com.hexaware.sis.service.*;
import java.util.List;
import java.util.Scanner;

public class MainModule {

    private static final IStudentService studentService = new StudentServiceImpl();
    private static final ICourseService courseService = new CourseServiceImpl();
    private static final IEnrollmentService enrollmentService = new EnrollmentServiceImpl();
    private static final IPaymentService paymentService = new PaymentServiceImpl();
    private static final ITeacherService teacherService = new TeacherServiceImpl();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        do {
            try {
                System.out.println("\nWelcome to Student Information System (SIS)");
                System.out.println("1. Register Student");
                System.out.println("2. Add Course");
                System.out.println("3. Enroll Student in Course");
                System.out.println("4. Make Payment");
                System.out.println("5. View Student by ID");
                System.out.println("6. View All Students");
                System.out.println("7. Assign Teacher to Course");
                System.out.println("8. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        registerStudent(scanner);
                        break;
                    case 2:
                        addCourse(scanner);
                        break;
                    case 3:
                        enrollStudentInCourse(scanner);
                        break;
                    case 4:
                        makePayment(scanner);
                        break;
                    case 5:
                        viewStudentById(scanner);
                        break;
                    case 6:
                        viewAllStudents();
                        break;
                    case 7:
                        assignTeacherToCourse(scanner);
                        break;
                    case 8:
                        System.out.println("Exiting the system...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (choice != 8);
    }

    private static void registerStudent(Scanner scanner) {
        try {
            System.out.print("Enter Student ID: ");
            int studentId = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter First Name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter Last Name: ");
            String lastName = scanner.nextLine();
            System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
            String dob = scanner.nextLine();
            System.out.print("Enter Email: ");
            String email = scanner.nextLine();
            System.out.print("Enter Phone Number: ");
            String phoneNumber = scanner.nextLine();

            Student student = new Student(studentId, firstName, lastName, dob, email, phoneNumber);
            studentService.registerStudent(student);
            System.out.println("Student registered successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void addCourse(Scanner scanner) {
        try {
            System.out.print("Enter Course ID: ");
            int courseId = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Course Name: ");
            String courseName = scanner.nextLine();
            System.out.print("Enter Credits: ");
            int credits = scanner.nextInt();
            System.out.print("Enter Teacher ID: ");
            int teacherId = scanner.nextInt();

            Course course = new Course(courseId, courseName, credits, teacherId);
            courseService.addCourse(course);
            System.out.println("Course added successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void enrollStudentInCourse(Scanner scanner) {
        try {
            System.out.print("Enter Student ID: ");
            int studentId = scanner.nextInt();
            System.out.print("Enter Course ID: ");
            int courseId = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Enrollment Date (YYYY-MM-DD): ");
            String enrollmentDate = scanner.nextLine();

            Student student = studentService.getStudentById(studentId);
            if (student == null) {
                System.out.println("Student not found!");
                return;
            }

            Course course = courseService.getCourseById(courseId);
            if (course == null) {
                System.out.println("Course not found!");
                return;
            }

            Enrollment enrollment = new Enrollment(0, student, course, enrollmentDate);
            enrollmentService.addEnrollment(enrollment);
            System.out.println("Student enrolled successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void makePayment(Scanner scanner) {
        try {
            System.out.print("Enter Student ID: ");
            int studentId = scanner.nextInt();
            System.out.print("Enter Payment Amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Payment Date (YYYY-MM-DD): ");
            String paymentDate = scanner.nextLine();

            Student student = studentService.getStudentById(studentId);
            if (student == null) {
                System.out.println("Student not found!");
                return;
            }

            Payment payment = new Payment(0, student, amount, paymentDate);
            paymentService.addPayment(payment);
            System.out.println("Payment made successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewStudentById(Scanner scanner) {
        try {
            System.out.print("Enter Student ID: ");
            int studentId = scanner.nextInt();
            Student student = studentService.getStudentById(studentId);
            if (student != null) {
                System.out.println("Student Information: " + student);
            } else {
                System.out.println("Student not found.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewAllStudents() {
        try {
            List<Student> students = studentService.getAllStudents();
            System.out.println("All Students:");
            for (Student student : students) {
                System.out.println(student);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void assignTeacherToCourse(Scanner scanner) {
        try {
            System.out.print("Enter Course ID: ");
            int courseId = scanner.nextInt();
            System.out.print("Enter Teacher ID: ");
            int teacherId = scanner.nextInt();

            Course course = courseService.getCourseById(courseId);
            if (course == null) {
                System.out.println("Course not found!");
                return;
            }

            Teacher teacher = teacherService.getTeacherById(teacherId);
            if (teacher == null) {
                System.out.println("Teacher not found!");
                return;
            }

            course.setTeacherId(teacherId);
            courseService.updateCourse(course);
            System.out.println("Teacher assigned to course successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

