package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KataStringCalculatorPairTest {
    @Test
    void be_zero() {
        assertEquals(0, KataStringCalculatorPair.Add(""));
    }
}