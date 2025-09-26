// File: edu/ccrm/cli/StudentMenu.java
package edu.ccrm.cli;

import edu.ccrm.domain.Student;
import edu.ccrm.service.StudentService;
import edu.ccrm.util.Validators;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class StudentMenu {

    private Scanner scanner;
    private StudentService studentService;

    public StudentMenu(Scanner scanner) {
        this.scanner = scanner;
        this.studentService = new StudentService();
    }

    public void showMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Student Management Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. List Students");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter choice: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> addStudent();
                case 2 -> updateStudent();
                case 3 -> listStudents();
                case 4 -> back = true;
                default -> System.out.println("Invalid selection. Try again.");
            }
        }
    }

    private void addStudent() {
        try {
            System.out.print("Enter Registration Number: ");
            String regNo = scanner.nextLine();
            if (!Validators.isValidRegNo(regNo)) {
                System.out.println("Invalid registration number format.");
                return;
            }

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            if (!Validators.isNonEmptyString(name)) {
                System.out.println("Name cannot be empty.");
                return;
            }

            System.out.print("Enter Email: ");
            String email = scanner.nextLine();
            if (!Validators.isValidEmail(email)) {
                System.out.println("Invalid email format.");
                return;
            }

            System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
            String dobInput = scanner.nextLine();
            LocalDate dob = LocalDate.parse(dobInput);

            int id = studentService.listAllStudents().size() + 1;

            Student student = new Student(id, regNo, name, email, dob);
            studentService.addStudent(student);

            System.out.println("Student added successfully with ID: " + id);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format.");
        } catch (Exception e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    private void updateStudent() {
        try {
            System.out.print("Enter Student ID to update: ");
            int id = Integer.parseInt(scanner.nextLine());
            var optStudent = studentService.getStudentById(id);
            if (optStudent.isEmpty()) {
                System.out.println("Student with ID " + id + " not found.");
                return;
            }

            Student student = optStudent.get();

            System.out.print("Enter updated Name (leave blank to keep: " + student.getName() + "): ");
            String name = scanner.nextLine();
            if (Validators.isNonEmptyString(name)) {
                student.setName(name);
            }

            System.out.print("Enter updated Email (leave blank to keep: " + student.getEmail() + "): ");
            String email = scanner.nextLine();
            if (Validators.isValidEmail(email)) {
                student.setEmail(email);
            } else if (!email.isBlank()) {
                System.out.println("Invalid email format. Email not updated.");
            }

            System.out.print("Is student active? (true/false, current: " + student.isActive() + "): ");
            String activeInput = scanner.nextLine();
            if (activeInput.equalsIgnoreCase("true") || activeInput.equalsIgnoreCase("false")) {
                student.setActive(Boolean.parseBoolean(activeInput));
            }

            studentService.updateStudent(student);
            System.out.println("Student details updated successfully.");

        } catch (NumberFormatException ex) {
            System.out.println("Invalid ID format.");
        }
    }

    private void listStudents() {
        List<Student> students = studentService.listAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("\n-- List of Students --");
        for (Student s : students) {
            System.out.printf("ID: %d, RegNo: %s, Name: %s, Email: %s, Active: %b\n",
                    s.getId(), s.getRegNo(), s.getName(), s.getEmail(), s.isActive());
        }
    }
}
