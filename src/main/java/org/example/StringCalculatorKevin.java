package org.example;
        import org.apache.commons.lang3.StringUtils;

        import java.util.Arrays;

public class StringCalculatorKevin {
    public static Integer sum(String expression) {
        final var defaultValue = 0;
        if (expression.isEmpty()) {
            return defaultValue;
        }
        var delimiter = ",";
        final var customDelimiterPrefix = "//";
        if (expression.startsWith(customDelimiterPrefix)) {
            delimiter = getCustomDelimiter(expression);
            expression = removeCustomDelimiter(expression);
        }
        if (expression.contains(delimiter)) {
            return sumNumbers(expression, delimiter);
        }
        return StringUtils.isNumeric(expression) ?
                Integer.parseInt(expression) : defaultValue;
    }

    private static String getCustomDelimiter(String expression) {
        final var customDelimiterPosition = 2;
        return expression.split("")[customDelimiterPosition];
    }

    private static String removeCustomDelimiter(String expression) {
        final var lastCustomDelimiterPosition = 4;
        expression = expression.substring(lastCustomDelimiterPosition);
        return expression;
    }

    private static Integer sumNumbers(String expression, String delimiter) {
        return Arrays.stream(expression.split(delimiter))
                .map(String::trim)
                .filter(StringUtils::isNumeric)
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
    }
}