package cc.somkiat.basicunittesting;

import org.junit.Test;

import cc.somkiat.basicunittesting.model.User;
import cc.somkiat.basicunittesting.validation.*;

import static org.junit.Assert.*;

public class EmailValidationTest {
    @Test
    public void อีเมลเป็นค่าว่าง() {
        ValidationRule validation = new EmptyEmailValidation();
        boolean result = validation.validate(new User("", ""));
        assertTrue(validation.getErrorMessage(), result);
    }

    @Test
    public void อีเมลไม่เป็นค่าว่าง() {
        ValidationRule validation = new EmptyEmailValidation();
        boolean result = validation.validate(new User("", "XenXorX@gmail.com"));
        assertFalse(ValidationRules.success, result);
    }

    @Test
    public void อีเมลไม่มีแอด() {
        ValidationRule validation = new EmailPatternValidation();
        boolean result = validation.validate(new User("", "XenXorXgmail.com"));
        assertTrue(validation.getErrorMessage(), result);
    }

    @Test
    public void อีเมลไม่มีโดเมน() {
        ValidationRule validation = new EmailPatternValidation();
        boolean result = validation.validate(new User("", "XenXorX@"));
        assertTrue(validation.getErrorMessage(), result);
    }

    @Test
    public void อีเมลโดเมนไม่สมบูรณ์() {
        ValidationRule validation = new EmailPatternValidation();
        boolean result = validation.validate(new User("", "XenXorX@gmailcom"));
        assertTrue(validation.getErrorMessage(), result);
    }

    @Test
    public void อีเมลมีแอดมากกว่าหนึ่งตัว() {
        ValidationRule validation = new EmailPatternValidation();
        boolean result = validation.validate(new User("", "Xen@XorX@gmail.com"));
        assertTrue(validation.getErrorMessage(), result);
    }

    @Test
    public void อีเมลมีตัวเลข() {
        ValidationRule validation = new EmailPatternValidation();
        boolean result = validation.validate(new User("", "XenXorX1234@gmail.com"));
        assertFalse(ValidationRules.success, result);
    }
}
