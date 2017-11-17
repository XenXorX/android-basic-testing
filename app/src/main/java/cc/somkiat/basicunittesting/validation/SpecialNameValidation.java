package cc.somkiat.basicunittesting.validation;

import java.util.regex.Pattern;

import cc.somkiat.basicunittesting.model.User;

public class SpecialNameValidation implements ValidationRule {

    @Override
    public boolean validate(User user) {
        return !Pattern.matches("^[a-zA-Z]+$", user.getUserName());
    }

    @Override
    public String getErrorMessage() {
        return "ไม่ผ่าน เพราะ username ต้องเป็นภาษาอังกฤษเท่านั้น";
    }
}
