// File: edu/ccrm/io/ImportExportService.java
package edu.ccrm.io;

import edu.ccrm.domain.Course;
import edu.ccrm.domain.Student;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class ImportExportService {

    public void exportStudentsToCSV(List<Student> students, Path filePath) throws IOException {
        // Actual implementation...
    }

    public List<Student> importStudentsFromCSV(Path filePath) throws IOException {
        // Actual implementation...
        return List.of();
    }

    public void exportCoursesToCSV(List<Course> courses, Path filePath) throws IOException {
        // Actual implementation...
    }

    public List<Course> importCoursesFromCSV(Path filePath) throws IOException {
        // Actual implementation...
        return List.of();
    }
}
