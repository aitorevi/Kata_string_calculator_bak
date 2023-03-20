package org.example;

/*
Punto 1:
"" -> 0 *
"1" -> 1 *
"2,2" -> 4 *
Punto 2
"2,2,2" -> 6 *
Punto 3
"1\n2,3" -> 6 *
Punto 4
"//;\n1;2;3" -> 6 *
Punto 5
"-1" -> Exception " negatives not allowed, -1"
"-1,3,5,-2" -> Exception " negatives not allowed, -1, -2"
*/

import java.util.List;
import java.util.stream.Collectors;

public class KataStringCalculator {
    public static void main(String[] args) {

    }

    public static int Add(String text) {

        if (text.equals("")) {
            return 0;
        }
        if (text.charAt(0) != '/') {
            var operationNumbers = refactorTextForExtractNumbersToCalculate(text);
            return operationNumbers.stream().reduce(0, Integer::sum);
        }
        String delimiter = extractDelimiterOfText(text);
        var operationNumbers = refactorTextWithDelimiterForExtractNumbersToCalculate(text, delimiter);
        return operationNumbers.stream().reduce(0, Integer::sum);
    }

    private static List<Integer> refactorTextForExtractNumbersToCalculate(String text) {
        var textNumbers = List.of(text.replaceAll("\n", ",").split(","));
        return textNumbers.stream().map(Integer::valueOf).collect(Collectors.toList());
    }

    private static String extractDelimiterOfText(String text) {
        return text.substring(2, 3);
    }

    private static List<Integer> refactorTextWithDelimiterForExtractNumbersToCalculate(String text, String delimiter) {
        String textWithoutDelimiter = text.substring(4);
        var textNumbers = List.of(textWithoutDelimiter.split(delimiter));
        return textNumbers.stream().map(Integer::valueOf).collect(Collectors.toList());
    }
}
