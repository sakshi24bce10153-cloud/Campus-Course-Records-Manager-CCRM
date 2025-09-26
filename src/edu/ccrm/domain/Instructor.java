// File: edu/ccrm/domain/Instructor.java
package edu.ccrm.domain;

import java.time.LocalDate;

public class Instructor extends Person {

    public Instructor(int id, String regNo, String name, String email, LocalDate dateOfBirth){
        super(id, regNo, name, email, dateOfBirth);
    }

    @Override
    public String getRole() {
        return "Instructor";
    }
}
