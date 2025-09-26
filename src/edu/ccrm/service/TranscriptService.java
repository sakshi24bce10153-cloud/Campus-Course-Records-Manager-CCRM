// File: edu/ccrm/service/TranscriptService.java
package edu.ccrm.service;

import edu.ccrm.domain.Enrollment;
import edu.ccrm.domain.Student;
import edu.ccrm.domain.Transcript;

import java.util.List;

public class TranscriptService {

    public Transcript generateTranscript(Student student, List<Enrollment> enrollments) {
        return new Transcript.Builder()
                .setStudent(student)
                .setEnrollments(enrollments)
                .build();
    }

    public double computeGPA(List<Enrollment> enrollments) {
        double totalPoints = 0;
        int totalCredits = 0;

        for (Enrollment e : enrollments) {
            if (e.getGrade() != null && e.getGrade() != edu.ccrm.domain.Grade.NOT_GRADED) {
                double gradePoints = gradeToPoints(e.getGrade());
                int credits = e.getCourse().getCredits();
                totalPoints += gradePoints * credits;
                totalCredits += credits;
            }
        }

        return totalCredits == 0 ? 0 : totalPoints / totalCredits;
    }

    private double gradeToPoints(edu.ccrm.domain.Grade grade) {
        return switch (grade) {
            case A -> 4.0;
            case B -> 3.0;
            case C -> 2.0;
            case D -> 1.0;
            case F, NOT_GRADED -> 0.0;
        };
    }
}
