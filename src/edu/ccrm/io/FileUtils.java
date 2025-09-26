// File: edu/ccrm/io/FileUtils.java
package edu.ccrm.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static List<Path> listFilesRecursively(Path directory) throws IOException {
        List<Path> fileList = new ArrayList<>();
        Files.walk(directory)
                .filter(Files::isRegularFile)
                .forEach(fileList::add);
        return fileList;
    }
}
