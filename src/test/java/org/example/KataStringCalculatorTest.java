package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KataStringCalculatorTest {

    @Test
    void be_zero() throws NegativeNumberException {
        assertEquals(0, KataStringCalculator.Add(""));
    }

    @Test
    void be_one() throws NegativeNumberException {
        assertEquals(1, KataStringCalculator.Add("1"));
    }

    @Test
    void be_result_of_calculator() throws NegativeNumberException {
        assertEquals(6, KataStringCalculator.Add("2,2,2"));
    }

    @Test
    void be_result_of_calculator_to_handle_new_lines_between_numbers() throws NegativeNumberException {
        assertEquals(6, KataStringCalculator.Add("1\n2,3"));
    }

    @Test
    void be_result_of_calculator_whit_custom_delimiter() throws NegativeNumberException {
        assertEquals(6, KataStringCalculator.Add("//;\n1;2;3"));
    }

    @Test
    void hay_numeros_negativos() throws NegativeNumberException {
        assertEquals("Error: Numbers negatives not allowed,(-2) ", KataStringCalculator.Add("1,-2,3"));
    }
}

