package com.foo;

import java.util.List;

public class NegativesNotAllowedException extends RuntimeException {
    public NegativesNotAllowedException(List<Integer> negative) {
        super(negative.toString());
    }
}
