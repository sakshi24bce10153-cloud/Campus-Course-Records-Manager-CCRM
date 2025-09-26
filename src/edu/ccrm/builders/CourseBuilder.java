// File: edu/ccrm/builders/CourseBuilder.java
package edu.ccrm.builders;

import edu.ccrm.domain.Course;
import edu.ccrm.domain.Instructor;
import edu.ccrm.domain.Semester;

import java.time.LocalDate;

public class CourseBuilder {
    private String code;
    private String title;
    private int credits;
    private Instructor instructor;
    private Semester semester;
    private String department;
    private boolean active = true;
    private LocalDate createdDate = LocalDate.now();

    public CourseBuilder setCode(String code) {
        this.code = code;
        return this;
    }

    public CourseBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public CourseBuilder setCredits(int credits) {
        this.credits = credits;
        return this;
    }

    public CourseBuilder setInstructor(Instructor instructor) {
        this.instructor = instructor;
        return this;
    }

    public CourseBuilder setSemester(Semester semester) {
        this.semester = semester;
        return this;
    }

    public CourseBuilder setDepartment(String department) {
        this.department = department;
        return this;
    }

    public CourseBuilder setActive(boolean active) {
        this.active = active;
        return this;
    }

    public CourseBuilder setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public Course build() {
        return new Course.Builder()
                .setCode(code)
                .setTitle(title)
                .setCredits(credits)
                .setInstructor(instructor)
                .setSemester(semester)
                .setDepartment(department)
                .setActive(active)
                .setCreatedDate(createdDate)
                .build();
    }
}
