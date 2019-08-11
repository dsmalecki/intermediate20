package pl.sda.intermediate.others;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    @Test
    void shouldReturnZeroIfTextIsBlank() {
        String text = "";

        int result = StringCalculator.adding(text);
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldReturnSumWhenGivenTwoNumbersInString() {
        String text = " 1, 2 ";

        int result = StringCalculator.adding(text);
        Assertions.assertEquals(3, result);
    }


    @Test
    void shouldReturnSumWhenGivenMultipleNumbersInString() {
        String text = " 1, 2 ,  3";

        int result = StringCalculator.adding(text);
        Assertions.assertEquals(6, result);
    }

    @Test
    void shouldReturnSumWhenGivenNumbersAndDelimitersAreNewLineSignAndCommaInString() {
        String text = " 1\n 2 ,4";

        int result = StringCalculator.adding(text);
        Assertions.assertEquals(7, result);
    }


    @Test
    void shouldReturnSumWhenGivenTwoNumbersAndRandomDelimiterInString() {
        String text = "//*\n 1* 2 ";

        int result = StringCalculator.adding(text);
        Assertions.assertEquals(3, result);
    }
}
