package cc.somkiat.basicunittesting.validation;

import java.util.regex.Pattern;

import cc.somkiat.basicunittesting.model.User;

public class EmailPatternValidation implements ValidationRule {
    private String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    public boolean validate(User user) {
        return !Pattern.matches(emailPattern, user.getEmail());
    }

    @Override
    public String getErrorMessage() {
        return "ไม่ผ่าน เพราะ ไม่เป็นไปตามรูปแบบของ email!";
    }
}
