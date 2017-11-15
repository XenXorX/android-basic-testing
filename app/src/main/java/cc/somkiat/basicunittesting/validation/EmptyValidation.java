package cc.somkiat.basicunittesting.validation;

import cc.somkiat.basicunittesting.model.User;

public class EmptyValidation extends ValidationRule {

    @Override
    public String validate(User user) {
        if (user.getUserName() == null || user.getUserName().isEmpty()) {
            result = "ไม่ผ่าน เพราะ username ว่าเป็นค่าว่าง!";
        }
        return result;
    }
}
