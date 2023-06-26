package caculation;

import java.math.BigDecimal;

public class NumberTest {

    public static void main(String[] args) {

        BigDecimal num1 = new BigDecimal("1.123");
        BigDecimal num2 = new BigDecimal("1.12300");
        num1.compareTo(num2);

    }
}
