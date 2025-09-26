# Campus Course Records Manager (CCRM)

## Project Overview
This project is a console-based Java SE application for managing campus course records, including students, courses, enrollments, grades, transcripts, and file data utilities. It demonstrates core Java SE concepts like OOP (Encapsulation, Inheritance, Polymorphism, Abstraction), Streams, Lambdas, Recursion, Enums, Nested classes, Design Patterns (Singleton, Builder), Modern IO (NIO.2), and robust exception handling.

### How to Run
- Use JDK 17 or later.
- Compile and run using these commands:
<img width="603" height="81" alt="image" src="https://github.com/user-attachments/assets/d27ec955-89b2-48a4-b86e-41d6e2646ff1" />

- In Eclipse, import the project as a Java project and run edu.ccrm.cli.MainMenu.

---

## Evolution of Java (Short Bullets)
- 1995: Java 1.0 released - platform independent, object-oriented.
- 1998: Java 2 (J2SE 1.2) - Swing, Collections.
- 2004: Java 5 - Generics, Annotations, Enhanced for-loop.
- 2014: Java 8 - Lambdas, Streams API, DateTime API.
- 2017: Java 9 - Module system.
- Current: Java 17 LTS - Sealed classes, Records, Pattern matching.

---

## Java ME vs SE vs EE Comparison

| Feature               | Java ME                              | Java SE                           | Java EE (Jakarta EE)              |
|-----------------------|------------------------------------|----------------------------------|----------------------------------|
| Purpose               | Embedded/mobile devices             | Desktop and server applications  | Enterprise-level web applications |
| Runtime Environment   | Lightweight, resource-constrained  | Standard Java Runtime            | Extends SE with web, EJB, JMS    |
| Libraries             | Limited standard libraries          | Full standard libraries          | Adds APIs like Servlets, JPA      |
| Use Case              | IoT, mobile phones                  | Desktop apps, utilities          | Large-scale distributed systems   |
| Development Complexity| Lower                             | Moderate                        | High                             |

---

## JDK, JRE, JVM Explanation

- *JVM (Java Virtual Machine):* Runs Java bytecode on any device/OS, providing platform independence.
- *JRE (Java Runtime Environment):* Includes JVM and core libraries to run Java applications.
- *JDK (Java Development Kit):* Includes JRE plus tools like compiler (javac), debuggers, and development utilities to build Java applications.

---

## Windows Installation Steps

1. Download JDK 17 or later from the official Oracle or OpenJDK site.
2. Run the installer and follow instructions.
3. Set environment variable JAVA_HOME to JDK install path.
4. Add JAVA_HOME\bin to PATH environment variable.
5. Verify installation with:
<img width="1476" height="762" alt="image" src="https://github.com/user-attachments/assets/3500cdec-57d2-42c9-9c7d-6c058774457f" />

---

## Eclipse Setup Steps

1. Download and install Eclipse IDE for Java Developers.
2. Launch Eclipse and select workspace folder.
3. Create a new Java Project and set source folder as src.
4. Add all source packages (edu.ccrm.*).
5. Run MainMenu.java as Java Application.

<img width="1919" height="1079" alt="image" src="https://github.com/user-attachments/assets/26f62795-1b9b-4e94-a5b1-afaf5a844951" />


---

## Mapping Table: Syllabus Topic → Implementation File/Class/Method

| Syllabus Topic                          | File/Package               | Class/Method                        |
|---------------------------------------|----------------------------|-----------------------------------|
| Abstraction & Inheritance              | domain                     | Person (abstract), Student, Course|
| Encapsulation                         | domain                     | Domain classes with private fields|
| Polymorphism                         | domain                     | Person.getRole() override          |
| Exception Handling                   | cli.StudentMenu            | addStudent() with input validation |
| Modern IO with NIO.2                 | io                         | ImportExportService, BackupService |
| Streams & Lambdas                   | service.CourseService      | searchCoursesByTitle()             |
| Enums                               | domain                     | Grade, Semester                    |
| Nested Classes                      | domain.Course              | Builder nested class               |
| Recursion                          | util.RecursionUtils        | factorial()                       |
| Design Patterns (Singleton, Builder) | config.AppConfig, builders | AppConfig singleton, CourseBuilder|

---

## Enabling Assertions and Sample Commands

- Enable assertions for runtime checks by running Java with -ea flag:
<img width="388" height="42" alt="image" src="https://github.com/user-attachments/assets/eaeb69ea-5aed-4e6f-a657-5f4b262e3f59" />

- Use assertions in code as:
<img width="460" height="29" alt="image" src="https://github.com/user-attachments/assets/fcb56c60-017d-4c4b-8878-2da84633f50f" />

- Assertions help catch programming errors during testing but are disabled by default in production.

---
