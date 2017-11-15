package cc.somkiat.basicunittesting;

import org.junit.Test;

import cc.somkiat.basicunittesting.model.User;

import static org.junit.Assert.*;

public class NameValidationTest {
    @Test
    public void ชื่อเป็นค่าว่าง() {
        ValidationRules validation = new ValidationRules();
        String result = validation.validate(new User("", ""));
        assertEquals("ไม่ผ่าน เพราะ username ว่าเป็นค่าว่าง!", result);
    }
}
