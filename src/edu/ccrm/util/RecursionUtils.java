// File: edu/ccrm/util/RecursionUtils.java
package edu.ccrm.util;

public class RecursionUtils {

    public static long factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
}
