package cc.somkiat.basicunittesting.validation;

import cc.somkiat.basicunittesting.model.User;

public class NameLengthValidation implements ValidationRule {

    @Override
    public boolean validate(User user) {
        return user.getUserName().length() < 2 || user.getUserName().length() > 20;
    }

    @Override
    public String getErrorMessage() {
        return "ไม่ผ่าน เพราะ username น้อยกว่า 2 หรือ มากว่า 20 ตัวอักษร!";
    }
}
