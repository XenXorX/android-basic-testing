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

    @Test
    public void อีเมลไม่มีโดเมน() {
        ValidationRule validation = new EmailPatternValidation();
        String result = validation.validate(new User("", "XenXorX@"));
        assertEquals(MyString.emailPatternError, result);
    }

    @Test
    public void อีเมลโดเมนไม่สมบูรณ์() {
        ValidationRule validation = new EmailPatternValidation();
        String result = validation.validate(new User("", "XenXorX@gmailcom"));
        assertEquals(MyString.emailPatternError, result);
    }

    @Test
    public void อีเมลมีแอดมากกว่าหนึ่งตัว() {
        ValidationRule validation = new EmailPatternValidation();
        String result = validation.validate(new User("", "Xen@XorX@gmailcom"));
        assertEquals(MyString.emailPatternError, result);
    }

    @Test
    public void อีเมลมีตัวเลข() {
        ValidationRule validation = new EmailPatternValidation();
        String result = validation.validate(new User("", "XenXorX1234@gmailcom"));
        assertEquals(MyString.emailPatternError, result);
    }
}
