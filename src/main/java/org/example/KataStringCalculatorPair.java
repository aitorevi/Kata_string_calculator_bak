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

public class KataStringCalculatorPair {
    public static void main(String[] args) {

    }
    public static int Add(String numbers) {

        if (!numbers.equals("")){
            if (numbers.charAt(0) == '/') {
                var delimiter = String.valueOf(numbers.charAt(2));
                var textOperationNumbers = List.of(numbers.substring(4).split(delimiter));
                var operationNumbers = textOperationNumbers.stream().map(Integer::valueOf).toList();
                return operationNumbers.stream().reduce(0, Integer::sum);
            }
            var textOperationNumbers = List.of(numbers.replaceAll("\n",",").split(","));
            var operationNumbers = textOperationNumbers.stream().map(Integer::valueOf).toList();
            return operationNumbers.stream().reduce(0, Integer::sum);
        }
        return 0;
    }
}
