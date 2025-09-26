// File: edu/ccrm/util/Validators.java
package edu.ccrm.util;

public class Validators {

    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");
    }

    public static boolean isValidRegNo(String regNo) {
        return regNo != null && regNo.matches("^[A-Z0-9]{4,10}$");
    }

    public static boolean isNonEmptyString(String str) {
        return str != null && !str.trim().isEmpty();
    }
}
