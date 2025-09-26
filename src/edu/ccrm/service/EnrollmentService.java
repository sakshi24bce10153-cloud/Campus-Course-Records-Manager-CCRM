// File: edu/ccrm/service/EnrollmentService.java
package edu.ccrm.service;

import edu.ccrm.domain.Enrollment;
import edu.ccrm.domain.Student;
import edu.ccrm.domain.Course;
import edu.ccrm.domain.Grade;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EnrollmentService {
    private final List<Enrollment> enrollments = new ArrayList<>();

    public void enrollStudent(Student student, Course course) {
        Optional<Enrollment> existing = enrollments.stream()
            .filter(e -> e.getStudent().getId() == student.getId() && e.getCourse().getCode().equals(course.getCode()))
            .findAny();
        if (existing.isEmpty()) {
            Enrollment enrollment = new Enrollment(student, course, LocalDate.now());
            enrollments.add(enrollment);
            student.enrollCourse(course);
        }
    }

    public void unenrollStudent(Student student, Course course) {
        enrollments.removeIf(e -> e.getStudent().getId() == student.getId() && e.getCourse().getCode().equals(course.getCode()));
        student.unenrollCourse(course);
    }

    public void recordGrade(Student student, Course course, Grade grade) {
        enrollments.stream()
            .filter(e -> e.getStudent().getId() == student.getId() && e.getCourse().getCode().equals(course.getCode()))
            .findFirst()
            .ifPresent(e -> e.setGrade(grade));
    }

    public List<Enrollment> getEnrollmentsByStudent(Student student) {
        List<Enrollment> results = new ArrayList<>();
        for (Enrollment e : enrollments) {
            if (e.getStudent().equals(student)) {
                results.add(e);
            }
        }
        return results;
    }
}
