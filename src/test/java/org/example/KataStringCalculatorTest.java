package org.example;

import org.junit.jupiter.api.Test;

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
    void be_negative_numbers() {
        var errorMessage = "Error: Numbers negatives not allowed,(-1)(-9)(-25)";
        NegativeNumberException capturedException = assertThrows(NegativeNumberException.class, () ->
                KataStringCalculatorPair.Add("-1,7,-9,-25"));
        assertEquals(errorMessage,capturedException.getMessage());
    }

    @Test
    void be_negative_numbers_with_custom_delimiter() {
        var errorMessage = "Error: Numbers negatives not allowed,(-1)(-9)";
        NegativeNumberException capturedException = assertThrows(NegativeNumberException.class, () ->
                KataStringCalculatorPair.Add("//;\n-1;7;-9"));
        assertEquals(errorMessage,capturedException.getMessage());
    }

}

