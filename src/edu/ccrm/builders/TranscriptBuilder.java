// File: edu/ccrm/builders/TranscriptBuilder.java
package edu.ccrm.builders;

import edu.ccrm.domain.Transcript;
import edu.ccrm.domain.Student;
import edu.ccrm.domain.Enrollment;

import java.util.List;

public class TranscriptBuilder {
    private Student student;
    private List<Enrollment> enrollments;

    public TranscriptBuilder setStudent(Student student) {
        this.student = student;
        return this;
    }

    public TranscriptBuilder setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
        return this;
    }

    public Transcript build() {
        return new Transcript.Builder()
                .setStudent(student)
                .setEnrollments(enrollments)
                .build();
    }
}
