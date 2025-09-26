// File: edu/ccrm/domain/Student.java
package edu.ccrm.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private boolean active;
    private List<Course> courses;

    public Student(int id, String regNo, String name, String email, LocalDate dateOfBirth) {
        super(id, regNo, name, email, dateOfBirth);
        this.active = true;
        this.courses = new ArrayList<>();
    }

    @Override
    public String getRole() {
        return "Student";
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void enrollCourse(Course course) {
        courses.add(course);
    }

    public void unenrollCourse(Course course) {
        courses.remove(course);
    }
}
