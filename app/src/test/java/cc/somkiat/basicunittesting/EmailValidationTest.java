package cc.somkiat.basicunittesting;

import org.junit.Test;

import cc.somkiat.basicunittesting.model.MyString;
import cc.somkiat.basicunittesting.model.User;
import cc.somkiat.basicunittesting.validation.*;

import static org.junit.Assert.*;

public class EmailValidationTest {
    @Test
    public void อีเมลเป็นค่าว่าง() {
        ValidationRule validation = new EmptyEmailValidation();
        String result = validation.validate(new User("", ""));
        assertEquals(MyString.emptyEmailError, result);
    }
}
