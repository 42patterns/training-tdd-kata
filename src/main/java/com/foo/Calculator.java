package com.foo;

import java.util.Arrays;

public class Calculator {
    final static String DEFAULT_DELIMETER = "[\n,]";

    public static Integer add(String input) {
        if (input == null || "".equals(input.trim())) {
            return 0;
        }

        return addImperative(input);
//        return addFunctional(input);
    }

    private static Integer addImperative(String input) {
        final String[] el = input.split(DEFAULT_DELIMETER);
        int sum = 0;
        for (String e: el) {
            if (e.matches("[0-9]+")) {
                sum += Integer.parseInt(e);
            }
        }

        return sum;
    }

    private static Integer addFunctional(String input) {
        return Arrays.stream(input.split(DEFAULT_DELIMETER))
                .map(Integer::parseInt)
                .reduce(Integer::sum)
                .orElse(0);
    }
}
