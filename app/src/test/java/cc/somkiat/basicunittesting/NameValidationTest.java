package cc.somkiat.basicunittesting;

import org.junit.Test;

import cc.somkiat.basicunittesting.model.MyString;
import cc.somkiat.basicunittesting.model.User;
import cc.somkiat.basicunittesting.validation.*;

import static org.junit.Assert.*;

public class NameValidationTest {
    @Test
    public void ชื่อเป็นค่าว่าง() {
        ValidationRule validation = new EmptyNameValidation();
        String result = validation.validate(new User("", ""));
        assertEquals(MyString.emptyNameError, result);
    }

    @Test
    public void ชื่อไม่เป็นค่าว่าง() {
        ValidationRule validation = new EmptyNameValidation();
        String result = validation.validate(new User("XenXorX", ""));
        assertEquals(MyString.success, result);
    }

    @Test
    public void ชื่อน้อยกว่าสองตัวอักษร() {
        ValidationRule validation = new NameLengthValidation();
        String result = validation.validate(new User("X", ""));
        assertEquals(MyString.nameLengthError, result);
    }

    @Test
    public void ชื่อมากกว่ายี่สิบตัวอักษร() {
        ValidationRule validation = new NameLengthValidation();
        String result = validation.validate(new User("XenXorXXenXorXXenXorX", ""));
        assertEquals(MyString.nameLengthError, result);
    }

    @Test
    public void ชื่อสองตัวอักษร() {
        ValidationRule validation = new NameLengthValidation();
        String result = validation.validate(new User("Xe", ""));
        assertEquals(MyString.success, result);
    }

    @Test
    public void ชื่อยี่สิบตัวอักษร() {
        ValidationRule validation = new NameLengthValidation();
        String result = validation.validate(new User("XenXorXXenXorXXenXor", ""));
        assertEquals(MyString.success, result);
    }

    @Test
    public void ชื่อสิบตัวอักษร() {
        ValidationRule validation = new NameLengthValidation();
        String result = validation.validate(new User("XenXorXXen", ""));
        assertEquals(MyString.success, result);
    }

    @Test
    public void ชื่อแปดตัวอักษร() {
        ValidationRule validation = new NameLengthValidation();
        String result = validation.validate(new User("XenXorXX", ""));
        assertEquals(MyString.success, result);
    }

    @Test
    public void ชื่อสิบหกตัวอักษร() {
        ValidationRule validation = new NameLengthValidation();
        String result = validation.validate(new User("XenXorXXenXorXXe", ""));
        assertEquals(MyString.success, result);
    }

    @Test
    public void ชื่อภาษาไทย() {
        ValidationRule validation = new SpecialNameValidation();
        String result = validation.validate(new User("ภาษาไทย", ""));
        assertEquals(MyString.specialNameError, result);
    }

    @Test
    public void ชื่ออังกฤษและภาษาไทย() {
        ValidationRule validation = new SpecialNameValidation();
        String result = validation.validate(new User("Englishภาษาไทย", ""));
        assertEquals(MyString.specialNameError, result);
    }

    @Test
    public void ชื่อภาษาไทยและอังกฤษ() {
        ValidationRule validation = new SpecialNameValidation();
        String result = validation.validate(new User("ภาษาไทยEnglish", ""));
        assertEquals(MyString.specialNameError, result);
    }

    @Test
    public void ชื่อภาษาอังกฤษ() {
        ValidationRule validation = new SpecialNameValidation();
        String result = validation.validate(new User("English", ""));
        assertEquals(MyString.success, result);
    }
}
