package cc.somkiat.basicunittesting;

import org.junit.Test;

import cc.somkiat.basicunittesting.model.User;
import cc.somkiat.basicunittesting.validation.*;

import static org.junit.Assert.*;

public class NameValidationTest {
    @Test
    public void ชื่อเป็นค่าว่าง() {
        ValidationRule validation = new EmptyNameValidation();
        boolean result = validation.validate(new User("", ""));
        assertTrue(validation.getErrorMessage(), result);
    }

    @Test
    public void ชื่อไม่เป็นค่าว่าง() {
        ValidationRule validation = new EmptyNameValidation();
        boolean result = validation.validate(new User("XenXorX", ""));
        assertFalse(ValidationRules.success, result);
    }

    @Test
    public void ชื่อน้อยกว่าสองตัวอักษร() {
        ValidationRule validation = new NameLengthValidation();
        boolean result = validation.validate(new User("X", ""));
        assertTrue(validation.getErrorMessage(), result);
    }

    @Test
    public void ชื่อมากกว่ายี่สิบตัวอักษร() {
        ValidationRule validation = new NameLengthValidation();
        boolean result = validation.validate(new User("XenXorXXenXorXXenXorX", ""));
        assertTrue(validation.getErrorMessage(), result);
    }

    @Test
    public void ชื่อสองตัวอักษร() {
        ValidationRule validation = new NameLengthValidation();
        boolean result = validation.validate(new User("Xe", ""));
        assertFalse(ValidationRules.success, result);
    }

    @Test
    public void ชื่อยี่สิบตัวอักษร() {
        ValidationRule validation = new NameLengthValidation();
        boolean result = validation.validate(new User("XenXorXXenXorXXenXor", ""));
        assertFalse(ValidationRules.success, result);
    }

    @Test
    public void ชื่อสิบตัวอักษร() {
        ValidationRule validation = new NameLengthValidation();
        boolean result = validation.validate(new User("XenXorXXen", ""));
        assertFalse(ValidationRules.success, result);
    }

    @Test
    public void ชื่อแปดตัวอักษร() {
        ValidationRule validation = new NameLengthValidation();
        boolean result = validation.validate(new User("XenXorXX", ""));
        assertFalse(ValidationRules.success, result);
    }

    @Test
    public void ชื่อสิบหกตัวอักษร() {
        ValidationRule validation = new NameLengthValidation();
        boolean result = validation.validate(new User("XenXorXXenXorXXe", ""));
        assertFalse(ValidationRules.success, result);
    }

    @Test
    public void ชื่อภาษาไทย() {
        ValidationRule validation = new SpecialNameValidation();
        boolean result = validation.validate(new User("ภาษาไทย", ""));
        assertTrue(validation.getErrorMessage(), result);
    }

    @Test
    public void ชื่ออังกฤษและภาษาไทย() {
        ValidationRule validation = new SpecialNameValidation();
        boolean result = validation.validate(new User("Englishภาษาไทย", ""));
        assertTrue(validation.getErrorMessage(), result);
    }

    @Test
    public void ชื่อภาษาไทยและอังกฤษ() {
        ValidationRule validation = new SpecialNameValidation();
        boolean result = validation.validate(new User("ภาษาไทยEnglish", ""));
        assertTrue(validation.getErrorMessage(), result);
    }

    @Test
    public void ชื่อภาษาอังกฤษ() {
        ValidationRule validation = new SpecialNameValidation();
        boolean result = validation.validate(new User("English", ""));
        assertFalse(ValidationRules.success, result);
    }
}
