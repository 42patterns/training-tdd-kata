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

    @Test
    public void should_return_input_for_single_param() {
        final String input = "5";
        Integer result = Calculator.add(input);

        assertThat(result, equalTo(5));
    }

    @Test
    public void should_sum_multiple_numbers() {
        final String input = "5,6,4";
        Integer result = Calculator.add(input);

        assertThat(result, equalTo(15));
    }

    @Test
    public void should_sum_multiple_numbers_with_newline_delimeter() {
        final String input = "5,6,4\n10";
        Integer result = Calculator.add(input);

        assertThat(result, equalTo(25));
    }

    @Test
    public void should_ignore_non_numeric() {
        final String input = "5,,a,b,4";
        Integer result = Calculator.add(input);

        assertThat(result, equalTo(9));
    }

}
