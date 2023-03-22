package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KataStringCalculatorPairTest {
    @Test
    void be_zero() {
        assertEquals(0, KataStringCalculatorPair.Add(""));
    }

    @Test
    void be_one() {
        assertEquals(1, KataStringCalculatorPair.Add("1"));
    }

    @Test
    void be_result_of_calculator() {
        assertEquals(6, KataStringCalculatorPair.Add("1,2,3"));
    }

    @Test
    void be_result_of_calculator_with_line_breaks() {
        assertEquals(6, KataStringCalculatorPair.Add("1\n2,3"));
    }
}