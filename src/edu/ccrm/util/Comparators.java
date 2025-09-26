// File: edu/ccrm/util/Comparators.java
package edu.ccrm.util;

import edu.ccrm.domain.Student;
import edu.ccrm.domain.Course;

import java.util.Comparator;

public class Comparators {

    public static Comparator<Student> byName() {
        return Comparator.comparing(Student::getName);
    }

    public static Comparator<Course> byTitle() {
        return Comparator.comparing(Course::getTitle);
    }
}
