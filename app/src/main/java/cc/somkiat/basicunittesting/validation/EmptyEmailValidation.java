package cc.somkiat.basicunittesting.validation;

import cc.somkiat.basicunittesting.model.User;

public class EmptyEmailValidation implements ValidationRule {

    @Override
    public boolean validate(User user) {
        return user.getEmail() == null || user.getEmail().isEmpty();
    }

    @Override
    public String getErrorMessage() {
        return "ไม่ผ่าน เพราะ email เป็นค่าว่าง!";
    }
}
