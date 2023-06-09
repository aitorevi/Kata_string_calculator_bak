package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * "" -> 0
 * "1" -> 1
 * "1,2" -> 3
 * "1,2,3" -> 6
 * "a" -> 0
 * "1,a" -> 1
 * "1,a,2" -> 3
 * "1a, 2" -> 2
 * "//#/3#2" -> 5
 * "//#/3,2" -> 0"
 * "//%/1%2%3" -> 6
 */

public class StringCalculatorKevinTest {
    @Test
    void does_not_count_empty() {
        assertThat(StringCalculatorKevin.sum("")).isEqualTo(0);
    }

    @Test
    void convert_text_in_to_number() {
        assertThat(StringCalculatorKevin.sum("1")).isEqualTo(1);
    }

    @Test
    void sum_numbers() {
        assertThat(StringCalculatorKevin.sum("1,2")).isEqualTo(3);
        assertThat(StringCalculatorKevin.sum("1,2,3")).isEqualTo(6);
    }

    @Test
    void ignore_not_numbers_on_sum() {
        assertThat(StringCalculatorKevin.sum("a")).isEqualTo(0);
        assertThat(StringCalculatorKevin.sum("1,a")).isEqualTo(1);
        assertThat(StringCalculatorKevin.sum("1,a,2")).isEqualTo(3);
    }

    @Test
    void ignore_spaces_on_sum() {
        assertThat(StringCalculatorKevin.sum("2 2, 2,3 ")).isEqualTo(5);
    }

    @Test
    void sum_with_custom_delimiter() {
        assertThat(StringCalculatorKevin.sum("//#/3#2")).isEqualTo(5);
        assertThat(StringCalculatorKevin.sum("//#/3,2")).isEqualTo(0);
        assertThat(StringCalculatorKevin.sum("//%/1%2%3")).isEqualTo(6);
    }
}