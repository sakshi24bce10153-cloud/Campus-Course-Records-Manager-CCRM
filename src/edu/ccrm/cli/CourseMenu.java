// File: edu/ccrm/cli/CourseMenu.java
package edu.ccrm.cli;

import edu.ccrm.domain.Course;
import edu.ccrm.domain.Instructor;
import edu.ccrm.domain.Semester;
import edu.ccrm.service.CourseService;
import edu.ccrm.util.Validators;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class CourseMenu {

    private Scanner scanner;
    private CourseService courseService;

    public CourseMenu(Scanner scanner) {
        this.scanner = scanner;
        this.courseService = new CourseService();
    }

    public void showMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Course Management Menu ---");
            System.out.println("1. Add Course");
            System.out.println("2. Update Course");
            System.out.println("3. List Courses");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter choice: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> addCourse();
                case 2 -> updateCourse();
                case 3 -> listCourses();
                case 4 -> back = true;
                default -> System.out.println("Invalid selection. Try again.");
            }
        }
    }

    private void addCourse() {
        try {
            System.out.print("Enter Course Code: ");
            String code = scanner.nextLine();
            if (!Validators.isNonEmptyString(code)) {
                System.out.println("Course code cannot be empty.");
                return;
            }

            System.out.print("Enter Course Title: ");
            String title = scanner.nextLine();
            if (!Validators.isNonEmptyString(title)) {
                System.out.println("Course title cannot be empty.");
                return;
            }

            System.out.print("Enter Credits (integer): ");
            int credits = Integer.parseInt(scanner.nextLine());

            // For simplicity, create dummy instructor (Extend to allow instructor selection)
            Instructor instructor = new Instructor(0, "INST001", "Default Instructor", "instructor@example.com", LocalDate.of(1980,1,1));

            System.out.print("Enter Semester (SPRING, SUMMER, FALL, WINTER): ");
            String semInput = scanner.nextLine().toUpperCase();
            Semester semester;
            try {
                semester = Semester.valueOf(semInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid semester.");
                return;
            }

            System.out.print("Enter Department: ");
            String department = scanner.nextLine();
            if (!Validators.isNonEmptyString(department)) {
                System.out.println("Department cannot be empty.");
                return;
            }

            Course course = new Course.Builder()
                    .setCode(code)
                    .setTitle(title)
                    .setCredits(credits)
                    .setInstructor(instructor)
                    .setSemester(semester)
                    .setDepartment(department)
                    .build();

            courseService.addCourse(course);
            System.out.println("Course added successfully: " + code);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input: Credits must be a number.");
        } catch (Exception e) {
            System.out.println("Error adding course: " + e.getMessage());
        }
    }

    private void updateCourse() {
        System.out.print("Enter Course Code to update: ");
        String code = scanner.nextLine();

        var optCourse = courseService.getCourseByCode(code);
        if (optCourse.isEmpty()) {
            System.out.println("Course with code " + code + " not found.");
            return;
        }

        Course course = optCourse.get();

        System.out.print("Enter new title (leave blank to keep: " + course.getTitle() + "): ");
        String title = scanner.nextLine();
        if (Validators.isNonEmptyString(title)) {
            course.setTitle(title);
        }

        System.out.print("Enter new credits (leave blank to keep: " + course.getCredits() + "): ");
        String creditsStr = scanner.nextLine();
        if (Validators.isNonEmptyString(creditsStr)) {
            try {
                int credits = Integer.parseInt(creditsStr);
                course.setCredits(credits);
            } catch (NumberFormatException e) {
                System.out.println("Invalid credits input, not updated.");
            }
        }

        // Instructor update skipped for simplicity, extend as needed

        System.out.print("Enter new semester (leave blank to keep: " + course.getSemester() + "): ");
        String semesterStr = scanner.nextLine();
        if (Validators.isNonEmptyString(semesterStr)) {
            try {
                Semester semester = Semester.valueOf(semesterStr.toUpperCase());
                course.setSemester(semester);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid semester input, not updated.");
            }
        }

        System.out.print("Enter new Department (leave blank to keep: " + course.getDepartment() + "): ");
        String department = scanner.nextLine();
        if (Validators.isNonEmptyString(department)) {
            course.setDepartment(department);
        }

        System.out.print("Is course active? (true/false, current: " + course.isActive() + "): ");
        String activeStr = scanner.nextLine();
        if (activeStr.equalsIgnoreCase("true") || activeStr.equalsIgnoreCase("false")) {
            course.setActive(Boolean.parseBoolean(activeStr));
        }

        courseService.updateCourse(course);
        System.out.println("Course updated successfully.");
    }

    private void listCourses() {
        List<Course> courses = courseService.listAllCourses();
        if (courses.isEmpty()) {
            System.out.println("No courses found.");
            return;
        }

        System.out.println("\n-- List of Courses --");
        for (Course course : courses) {
            System.out.printf("Code: %s, Title: %s, Credits: %d, Semester: %s, Dept: %s, Active: %b\n",
                    course.getCode(), course.getTitle(), course.getCredits(),
                    course.getSemester(), course.getDepartment(), course.isActive());
        }
    }
}
