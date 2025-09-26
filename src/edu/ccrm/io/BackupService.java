// File: edu/ccrm/io/BackupService.java
package edu.ccrm.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BackupService {

    private static BackupService instance;

    private BackupService() {}

    public static BackupService getInstance() {
        if (instance == null) {
            instance = new BackupService();
        }
        return instance;
    }

    public Path backupData(Path sourceDirectory, Path backupRootDirectory) throws IOException {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        Path backupDir = backupRootDirectory.resolve("backup_" + timestamp);

        Files.createDirectories(backupDir);
        Files.walk(sourceDirectory).forEach(source -> {
            try {
                Path destination = backupDir.resolve(sourceDirectory.relativize(source));
                if (Files.isDirectory(source)) {
                    Files.createDirectories(destination);
                } else {
                    Files.copy(source, destination);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return backupDir;
    }
}
