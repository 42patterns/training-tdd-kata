package com.foo;

import java.util.*;
import java.util.stream.Collectors;

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
        final List<Integer> negative = new ArrayList<>();

        int sum = 0;
        for (String e: el) {
            if (e.matches("-?[0-9]+")) {
                int i = Integer.parseInt(e);
                if (i < 1000) {
                    if (i < 0) {
                        negative.add(i);
                    } else {
                        sum += i;
                    }
                }
            }
        }

        if (!negative.isEmpty()) {
            throw new NegativesNotAllowedException(negative);
        }

        return sum;
    }

    private static Integer addFunctional(String input) {
        Map<Boolean, List<Integer>> collect = Arrays.stream(input.split(DEFAULT_DELIMETER))
                .filter(s -> s.matches("-?[0-9]+"))
                .map(Integer::parseInt)
                .filter(i -> i < 1000)
                .collect(Collectors.partitioningBy(i -> i > 0));

        List<Integer> positive = collect.getOrDefault(true, Collections.emptyList());
        List<Integer> negative = collect.getOrDefault(false, Collections.emptyList());

        if (!negative.isEmpty()) {
            throw new NegativesNotAllowedException(negative);
        }

        return positive.stream()
                .reduce(Integer::sum)
                .orElse(0);
    }
}
