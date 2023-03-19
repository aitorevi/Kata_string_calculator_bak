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
"-1" -> Exception " negatives not allowed"
"-1,3,5,-2" -> Exception " negatives not allowed, -1, -2"
*/

public class KataStringCalculator {
    public static void main(String[] args) {

    }

    public static int Add(String text) {

        int resultSum = 0;
        if (text.equals("")) {
            return 0;
        }
        if (!text.substring(0, 1).equals("/")) {
            var operationNumbers = refactorTextForExtractNumbersToCalculate(text);
            for (String value : operationNumbers) {
                resultSum = resultSum + Integer.parseInt(value);
            }
            return resultSum;
        }
        String delimiter = extractDelimiterOfText(text);
        String[] operationNumbers = refactorTextWithDelimiterForExtractNumbersToCalculate(text, delimiter);
        for (String value : operationNumbers) {
            resultSum = resultSum + Integer.parseInt(value);
        }
        return resultSum;
    }


    private static String[] refactorTextForExtractNumbersToCalculate(String text) {
        return text.replaceAll("\n", ",").split(",");
    }

    private static String extractDelimiterOfText(String text) {
        String delimiter = text.substring(2, 3);
        return delimiter;
    }

    private static String[] refactorTextWithDelimiterForExtractNumbersToCalculate(String text, String delimiter) {
        String textWithoutDelimiter = text.substring(4);
        String[] operationNumbers = textWithoutDelimiter.split(delimiter);
        return operationNumbers;
    }
}
