package pl.sda.intermediate;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BigDecimalTest {
    @Test
    void bigDecimal() {
        double a = 0.02;
        double b = 0.03;
        System.out.println(a - b + " double");

        BigDecimal c = new BigDecimal(0.02);
        BigDecimal d = new BigDecimal(0.03);
        System.out.println(c.subtract(d) + " bad BigDecimal usage");

        BigDecimal e = BigDecimal.valueOf(0.02);
        BigDecimal f = BigDecimal.valueOf(0.03);
        System.out.println(e.subtract(f) + " gute BigDecimal usage");


    }
}
