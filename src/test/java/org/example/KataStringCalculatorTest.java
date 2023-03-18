package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KataStringCalculatorTest {

    @Test
    void be_zero() {
        assertEquals(0, KataStringCalculator.Add(List.of("")));
    }

    @Test
    void be_one() {
        assertEquals(1, KataStringCalculator.Add(List.of("1")));
    }

    @Test
    void be_result_of_calculator() {
        assertEquals(6, KataStringCalculator.Add(List.of("2", "2", "2")));
    }
}