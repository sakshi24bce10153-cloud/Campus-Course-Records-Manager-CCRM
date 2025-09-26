// File: edu/ccrm/cli/MainMenu.java
package edu.ccrm.cli;

import java.util.Scanner;

public class MainMenu {

    private Scanner scanner = new Scanner(System.in);

    public void start() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== Campus Course Records Manager Main Menu ===");
            System.out.println("1. Student Management");
            System.out.println("2. Course Management");
            System.out.println("3. Enrollment and Grading");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> new StudentMenu(scanner).showMenu();
                case 2 -> new CourseMenu(scanner).showMenu();
                case 3 -> new EnrollmentMenu(scanner).showMenu();
                case 4 -> exit = true;
                default -> System.out.println("Invalid selection. Try again.");
            }
        }
        System.out.println("Exiting Campus Course Records Manager.");
    }

    public static void main(String[] args) {
        new MainMenu().start();
    }
}
