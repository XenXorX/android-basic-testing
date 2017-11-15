package cc.somkiat.basicunittesting;

import org.junit.Test;

import cc.somkiat.basicunittesting.model.MyString;
import cc.somkiat.basicunittesting.model.User;

import static org.junit.Assert.*;

public class NameValidationTest {
    @Test
    public void ชื่อเป็นค่าว่าง() {
        ValidationRules validation = new ValidationRules();
        String result = validation.validate(new User("", ""));
        assertEquals(MyString.emptyNameError, result);
    }

    @Test
    public void ชื่อไม่เป็นค่าว่าง() {
        ValidationRules validation = new ValidationRules();
        String result = validation.validate(new User("XenXorX", ""));
        assertEquals(MyString.success, result);
    }

    @Test
    public void ชื่อน้อยกว่าสองตัวอักษร() {
        ValidationRules validation = new ValidationRules();
        String result = validation.validate(new User("X", ""));
        assertEquals(MyString.nameLengthError, result);
    }
}
