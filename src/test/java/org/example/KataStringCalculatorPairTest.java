package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KataStringCalculatorPairTest {
    @Test
    void be_zero() throws NegativeNumberException {
        assertEquals(0, KataStringCalculatorPair.Add(""));
    }

    @Test
    void be_one() throws NegativeNumberException {
        assertEquals(1, KataStringCalculatorPair.Add("1"));
    }

    @Test
    void be_result_of_calculator() throws NegativeNumberException {
        assertEquals(6, KataStringCalculatorPair.Add("1,2,3"));
    }

    @Test
    void be_result_of_calculator_with_line_breaks() throws NegativeNumberException {
        assertEquals(6, KataStringCalculatorPair.Add("1\n2,3"));
    }
    @Test
    void be_result_of_calculator_with_custom_delimiter() throws NegativeNumberException {
        assertEquals(3,KataStringCalculatorPair.Add("//;\n1;2"));
    }
}