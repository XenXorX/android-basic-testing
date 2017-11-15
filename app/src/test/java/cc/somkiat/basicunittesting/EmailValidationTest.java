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

    @Test
    public void อีเมลไม่เป็นค่าว่าง() {
        ValidationRule validation = new EmptyEmailValidation();
        String result = validation.validate(new User("", "XenXorX@gmail.com"));
        assertEquals(MyString.success, result);
    }

    @Test
    public void อีเมลไม่มีแอด() {
        ValidationRule validation = new EmailPatternValidation();
        String result = validation.validate(new User("", "XenXorXgmail.com"));
        assertEquals(MyString.emailPatternError, result);
    }
}
