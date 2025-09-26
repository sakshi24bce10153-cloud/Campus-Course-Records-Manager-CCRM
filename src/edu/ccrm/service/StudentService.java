// File: edu/ccrm/service/StudentService.java
package edu.ccrm.service;

import edu.ccrm.domain.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentService {
    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public Optional<Student> getStudentById(int id) {
        return students.stream().filter(s -> s.getId() == id).findFirst();
    }

    public List<Student> listAllStudents() {
        return new ArrayList<>(students);
    }

    public void updateStudent(Student student) {
        getStudentById(student.getId()).ifPresent(existing -> {
            existing.setName(student.getName());
            existing.setEmail(student.getEmail());
            existing.setActive(student.isActive());
        });
    }

    public void deactivateStudent(int id) {
        getStudentById(id).ifPresent(student -> student.setActive(false));
    }
}
