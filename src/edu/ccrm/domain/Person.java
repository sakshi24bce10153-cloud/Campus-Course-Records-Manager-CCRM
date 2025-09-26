// File: edu/ccrm/domain/Person.java
package edu.ccrm.domain;

import java.time.LocalDate;

public abstract class Person {
    protected int id;
    protected String regNo;
    protected String name;
    protected String email;
    protected LocalDate dateOfBirth;

    public Person(int id, String regNo, String name, String email, LocalDate dateOfBirth) {
        this.id = id;
        this.regNo = regNo;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public abstract String getRole();


    public int getId() {
        return id;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
