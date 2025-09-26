// File: edu/ccrm/cli/EnrollmentMenu.java
package edu.ccrm.cli;

import edu.ccrm.domain.*;
import edu.ccrm.service.EnrollmentService;
import edu.ccrm.service.StudentService;
import edu.ccrm.service.CourseService;
import edu.ccrm.service.TranscriptService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class EnrollmentMenu {

    private Scanner scanner;
    private EnrollmentService enrollmentService;
    private StudentService studentService;
    private CourseService courseService;
    private TranscriptService transcriptService;

    public EnrollmentMenu(Scanner scanner) {
        this.scanner = scanner;
        this.enrollmentService = new EnrollmentService();
        this.studentService = new StudentService();
        this.courseService = new CourseService();
        this.transcriptService = new TranscriptService();
    }

    public void showMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Enrollment and Grading Menu ---");
            System.out.println("1. Enroll Student");
            System.out.println("2. Unenroll Student");
            System.out.println("3. Record Grade");
            System.out.println("4. Generate Transcript");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter choice: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> enrollStudent();
                case 2 -> unenrollStudent();
                case 3 -> recordGrade();
                case 4 -> generateTranscript();
                case 5 -> back = true;
                default -> System.out.println("Invalid selection. Try again.");
            }
        }
    }

    private void enrollStudent() {
        try {
            System.out.print("Enter Student ID: ");
            int studentId = Integer.parseInt(scanner.nextLine());
            Optional<Student> studentOpt = studentService.getStudentById(studentId);
            if (studentOpt.isEmpty()) {
                System.out.println("Student not found.");
                return;
            }

            System.out.print("Enter Course Code: ");
            String courseCode = scanner.nextLine();
            Optional<Course> courseOpt = courseService.getCourseByCode(courseCode);
            if (courseOpt.isEmpty()) {
                System.out.println("Course not found.");
                return;
            }

            enrollmentService.enrollStudent(studentOpt.get(), courseOpt.get());
            System.out.println("Student enrolled successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
    }

    private void unenrollStudent() {
        try {
            System.out.print("Enter Student ID: ");
            int studentId = Integer.parseInt(scanner.nextLine());
            Optional<Student> studentOpt = studentService.getStudentById(studentId);
            if (studentOpt.isEmpty()) {
                System.out.println("Student not found.");
                return;
            }

            System.out.print("Enter Course Code: ");
            String courseCode = scanner.nextLine();
            Optional<Course> courseOpt = courseService.getCourseByCode(courseCode);
            if (courseOpt.isEmpty()) {
                System.out.println("Course not found.");
                return;
            }

            enrollmentService.unenrollStudent(studentOpt.get(), courseOpt.get());
            System.out.println("Student unenrolled successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
    }

    private void recordGrade() {
        try {
            System.out.print("Enter Student ID: ");
            int studentId = Integer.parseInt(scanner.nextLine());
            Optional<Student> studentOpt = studentService.getStudentById(studentId);
            if (studentOpt.isEmpty()) {
                System.out.println("Student not found.");
                return;
            }

            System.out.print("Enter Course Code: ");
            String courseCode = scanner.nextLine();
            Optional<Course> courseOpt = courseService.getCourseByCode(courseCode);
            if (courseOpt.isEmpty()) {
                System.out.println("Course not found.");
                return;
            }

            System.out.print("Enter Grade (A, B, C, D, F): ");
            String gradeStr = scanner.nextLine().toUpperCase();
            Grade grade;
            try {
                grade = Grade.valueOf(gradeStr);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid grade.");
                return;
            }

            enrollmentService.recordGrade(studentOpt.get(), courseOpt.get(), grade);
            System.out.println("Grade recorded successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
    }

    private void generateTranscript() {
        try {
            System.out.print("Enter Student ID: ");
            int studentId = Integer.parseInt(scanner.nextLine());
            Optional<Student> studentOpt = studentService.getStudentById(studentId);
            if (studentOpt.isEmpty()) {
                System.out.println("Student not found.");
                return;
            }
            Student student = studentOpt.get();

            List<Enrollment> enrollments = enrollmentService.getEnrollmentsByStudent(student);
            if (enrollments.isEmpty()) {
                System.out.println("No enrollments found for this student.");
                return;
            }

            var transcript = transcriptService.generateTranscript(student, enrollments);
            double gpa = transcriptService.computeGPA(enrollments);

            System.out.println("\n--- Transcript for Student: " + student.getName() + " ---");
            for (Enrollment enrollment : enrollments) {
                System.out.printf("Course: %s, Grade: %s\n", enrollment.getCourse().getTitle(), enrollment.getGrade());
            }
            System.out.printf("GPA: %.2f\n", gpa);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
    }
}
