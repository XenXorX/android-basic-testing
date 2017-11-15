package cc.somkiat.basicunittesting;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void สองบวกสองเท่ากับสี่() {
        Calculator cal = new Calculator();
        int result = cal.plus(2,2);
        assertEquals(4, result);
    }

    @Test
    public void เจ็ดบวกสองเท่ากับเก้า() {
        Calculator cal = new Calculator();
        int result = cal.plus(7,2);
        assertEquals(9, result);
    }
}
