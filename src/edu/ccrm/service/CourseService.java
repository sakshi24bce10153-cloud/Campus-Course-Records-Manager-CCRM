// File: edu/ccrm/service/CourseService.java
package edu.ccrm.service;

import edu.ccrm.domain.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CourseService {
    private final List<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {
        courses.add(course);
    }

    public Optional<Course> getCourseByCode(String code) {
        return courses.stream().filter(c -> c.getCode().equalsIgnoreCase(code)).findFirst();
    }

    public List<Course> listAllCourses() {
        return new ArrayList<>(courses);
    }

    public List<Course> searchCoursesByTitle(String title) {
        return courses.stream()
                .filter(c -> c.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void updateCourse(Course updatedCourse) {
        getCourseByCode(updatedCourse.getCode()).ifPresent(course -> {
            course.setTitle(updatedCourse.getTitle());
            course.setCredits(updatedCourse.getCredits());
            course.setInstructor(updatedCourse.getInstructor());
            course.setSemester(updatedCourse.getSemester());
            course.setDepartment(updatedCourse.getDepartment());
            course.setActive(updatedCourse.isActive());
        });
    }

    public void deactivateCourse(String code) {
        getCourseByCode(code).ifPresent(course -> course.setActive(false));
    }
}
