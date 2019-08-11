package pl.sda.intermediate.others;

import org.apache.commons.lang3.StringUtils;

public class StringCalculator {
    public static int adding(String text) {
        if (StringUtils.isBlank(text)) {
            return 0;
        }

        int sum = 0;
        String delimiterRegex;

        if (text.startsWith("//")) {
            delimiterRegex = "" + text.charAt(2);
            String[] splitByN = text.split("\n");
            text = splitByN[1];
        } else {
            delimiterRegex = ",|\n";
        }
//        text = text.replaceAll("\n", ",");
        String[] splitStrings = text.split(delimiterRegex); //zastąpienie linijki wyżej regexem
        for (String splitString : splitStrings) {
            sum = sum + Integer.parseInt(splitString.trim());
        }
        return sum;
    }
}
