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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class KataStringCalculatorPair {
    public static void main(String[] args) {
        var text = "2***321654******54***5254*1564***5611**491*15*518*1********45*";
        var delimiterSimply = "*";
        var previusCharString = "";
        List<String> previousTextRefactorForCalculator = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            var indexString = text.substring(i,i+1);
            if (!indexString.equals(delimiterSimply) || !indexString.equals(previusCharString)) {
                previousTextRefactorForCalculator.add(indexString);
            }
            previusCharString = indexString;
        }
        StringBuilder textRefactorCalculator = new StringBuilder();
        for (String character : previousTextRefactorForCalculator) {
            textRefactorCalculator.append(character);
        }
        System.out.println(textRefactorCalculator);
    }
    public static int Add(String numbers) throws NegativeNumberException {

        if (!numbers.equals("")){
            if (numbers.charAt(0) == '/') {
                var delimiter = extractDelimiterOfText(numbers);
                var operationNumbers = refactorTextWithDelimiterForExtractNumbersToCalculate(numbers,delimiter);
                var negativeNumbers = extractNegativeNumbers(operationNumbers);
                if (!negativeNumbers.isEmpty()) {
                    var errorMessage = errorMessageException(negativeNumbers);
                    throw new NegativeNumberException(errorMessage);
                }
                return solvedCalculation(operationNumbers);
            }
            var operationNumbers = refactorTextForExtractNumbersToCalculate(numbers);
            var negativeNumbers = extractNegativeNumbers(operationNumbers);
            if (!negativeNumbers.isEmpty()) {
                var errorMessage = errorMessageException(negativeNumbers);
                throw new NegativeNumberException(errorMessage);
            }
            return solvedCalculation(refactorTextForExtractNumbersToCalculate(numbers));
        }
        return 0;
    }
    private static List<Integer> extractNegativeNumbers(List<Integer> operationNumbers){
        List<Integer> negativeNumber = new ArrayList();
        for (Integer number : operationNumbers) {
            if (number < 0) {
                negativeNumber.add(number);
            }
        }
        return negativeNumber;
    }
    private static String errorMessageException(List<Integer> negativeNumbers){
        StringBuilder errorMessage = new StringBuilder("Error: Numbers negatives not allowed,");
        for (Integer number : negativeNumbers) {
            errorMessage.append("(").append(number).append(")");
        }
        return errorMessage.toString();
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
        return textOperationNumbers.stream().map(Integer::valueOf).toList();
    }
    private static Integer solvedCalculation(List<Integer>operationNumbers) {
        return operationNumbers.stream().reduce(0, Integer::sum);
    }
}
