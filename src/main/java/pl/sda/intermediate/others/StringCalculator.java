package pl.sda.intermediate.others;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class StringCalculator {
    public static int adding(String text) {
        if (StringUtils.isBlank(text)) {
            return 0;
        }

        int sum = 0;
        String delimiterRegex;
        String[] splitStrings;
        if (text.startsWith("//")) {
            delimiterRegex = "" + text.charAt(2);
            String[] splitByN = text.split("\n");
            text = splitByN[1];
            splitStrings = text.split(Pattern.quote(delimiterRegex)); // tutaj escapujemy znaki specjalne (quote)
        } else {
            delimiterRegex = ",|\n";
            splitStrings = text.split(delimiterRegex);
        }
        for (String splitString : splitStrings) {
            sum = sum + Integer.parseInt(splitString.trim());
        }
        return sum;
    }
}
