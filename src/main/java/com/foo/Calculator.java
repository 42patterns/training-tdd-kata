package com.foo;

import java.util.Arrays;

public class Calculator {
    final static String DEFAULT_DELIMETER = "[\n,]";

    public static Integer add(String input) {
        if (input == null || "".equals(input.trim())) {
            return 0;
        }

//        return addImperative(input);
        return addFunctional(input);
    }

    private static Integer addImperative(String input) {
        final String[] el = input.split(DEFAULT_DELIMETER);
        int sum = 0;
        for (String e: el) {
            if (e.matches("[0-9]+")) {
                int i = Integer.parseInt(e);
                if (i < 1000) {
                    sum += i;
                }
            }
        }

        return sum;
    }

    private static Integer addFunctional(String input) {
        return Arrays.stream(input.split(DEFAULT_DELIMETER))
                .filter(s -> s.matches("[0-9]+"))
                .map(Integer::parseInt)
                .filter(i -> i < 1000)
                .reduce(Integer::sum)
                .orElse(0);
    }
}
