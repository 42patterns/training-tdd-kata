package com.foo;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    @Test
    public void should_return_zero_for_empty_string() {
        final String input = " ";
        Integer result = Calculator.add(input);

        assertThat(result, equalTo(0));
    }

}
