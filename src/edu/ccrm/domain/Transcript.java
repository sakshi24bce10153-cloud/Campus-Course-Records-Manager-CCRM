// File: edu/ccrm/domain/Transcript.java
package edu.ccrm.domain;

import java.util.List;

public class Transcript {
    private Student student;
    private List<Enrollment> enrollments;

    private Transcript(Builder builder) {
        this.student = builder.student;
        this.enrollments = builder.enrollments;
    }

    public Student getStudent() {
        return student;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public static class Builder {
        private Student student;
        private List<Enrollment> enrollments;

        public Builder setStudent(Student student) {
            this.student = student;
            return this;
        }
        public Builder setEnrollments(List<Enrollment> enrollments) {
            this.enrollments = enrollments;
            return this;
        }
        public Transcript build() {
            return new Transcript(this);
        }
    }
}
