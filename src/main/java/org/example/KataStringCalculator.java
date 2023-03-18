package org.example;

/*
Punto 1:
"" -> 0 *
"1" -> 1 *
"2,2" -> 4 *
*/

import java.util.List;

public class KataStringCalculator {

    public static int Add(List<String> numbers) {
        int resultSum = 0;
        for (String value : numbers) {
            if (!value.equals("")) {
                resultSum = resultSum + Integer.parseInt(value);
            }
            if (value.equals("")) {
                return 0;
            }
        }
        return resultSum;
    }
}
