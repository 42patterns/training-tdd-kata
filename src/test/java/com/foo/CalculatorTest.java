package com.foo;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

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

    @Test
    public void should_ignore_number_bigger_than_1000() {
        final String input = "5,6,1,1000";
        Integer result = Calculator.add(input);

        assertThat(result, equalTo(12));
    }

    @Test
    public void should_throw_exeption_on_negative() {
        final String input = "5,-6,-4,b,4";

        try {
            Calculator.add(input);
            fail("Exception expected");
        } catch (Exception e) {
            assertThat(e.getMessage(), containsString("-4"));
            assertThat(e.getMessage(), containsString("-6"));
        }

    }




}
