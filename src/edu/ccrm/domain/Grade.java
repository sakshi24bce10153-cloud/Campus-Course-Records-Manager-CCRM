// File: edu/ccrm/domain/Grade.java
package edu.ccrm.domain;

public enum Grade {
    A, B, C, D, F, NOT_GRADED;

    public static char toLetter(double marks) {
        if (marks >= 90) return 'A';
        if (marks >= 80) return 'B';
        if (marks >= 70) return 'C';
        if (marks >= 60) return 'D';
        return 'F';
    }
}
