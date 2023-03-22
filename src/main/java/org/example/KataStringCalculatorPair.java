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
"//;\n1;2;3;3;4;33" -> 6 *
Punto 5
"-1" -> Exception " negatives not allowed, -1"
"-1,3,5,-2" -> Exception " negatives not allowed, -1, -2"
*/

import java.util.List;
import java.util.stream.Collectors;

public class KataStringCalculatorPair {
    public static void main(String[] args) {

    }
    public static int Add(String numbers) {

        if (!numbers.equals("")){
            if (numbers.charAt(0) == '/') {
                var delimiter = extractDelimiterOfText(numbers);
                var operationNumbers = refactorTextWithDelimiterForExtractNumbersToCalculate(numbers,delimiter);
                return solvedCalculation(operationNumbers);
            }
            return solvedCalculation(refactorTextForExtractNumbersToCalculate(numbers));
        }
        return 0;
    }

    private static String extractDelimiterOfText(String numbers) {
        return numbers.substring(2, 3);
    }
    private static List<Integer> refactorTextWithDelimiterForExtractNumbersToCalculate(String text, String delimiter) {
        var textNumbers = List.of(text.substring(4).split(delimiter));
        return textNumbers.stream().map(Integer::valueOf).toList();
    }
    private static List<Integer> refactorTextForExtractNumbersToCalculate(String numbers) {
        var textOperationNumbers = List.of(numbers.replaceAll("\n",",").split(","));
        var operationNumbers = textOperationNumbers.stream().map(Integer::valueOf).toList();
        return operationNumbers;
    }
    private static Integer solvedCalculation(List<Integer>operationNumbers) {
        return operationNumbers.stream().reduce(0, Integer::sum);
    }
}
