package com.foo;

public class Calculator {
    public static Integer add(String input) {
        if (input == null || "".equals(input.trim())) {
            return 0;
        }

        return Integer.parseInt(input);
    }
}
