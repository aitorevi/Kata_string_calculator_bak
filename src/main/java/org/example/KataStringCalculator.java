package org.example;

/*
Punto 1:
"" -> 0 *
"1" -> 1 *
"2,2" -> 4 *
Punto 2
"2,2,2" -> 6 *
Punto 3
"1\n2,3" -> 6
*/

import java.util.List;

public class KataStringCalculator {

    public static int Add(String text) {
        var arrayNumbers = text.split(",");
        int resultSum = 0;
        for (String value : arrayNumbers) {
            if (!value.equals("") && (!value.equals("\n"))) {
                resultSum = resultSum + Integer.parseInt(value);
            }
            if (value.equals("")) {
                return 0;
            }
        }
        return resultSum;
    }
}
