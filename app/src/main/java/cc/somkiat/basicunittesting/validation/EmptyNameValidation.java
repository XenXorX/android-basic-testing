package cc.somkiat.basicunittesting.validation;

import cc.somkiat.basicunittesting.model.User;

public class EmptyNameValidation implements ValidationRule {

    @Override
    public boolean validate(User user) {
        return user.getUserName() == null || user.getUserName().isEmpty();
    }

    @Override
    public String getErrorMessage() {
        return "ไม่ผ่าน เพราะ username เป็นค่าว่าง!";
    }
}
