package cc.somkiat.basicunittesting.validation;

import cc.somkiat.basicunittesting.model.MyString;
import cc.somkiat.basicunittesting.model.User;

public class EmptyNameValidation extends ValidationRule {

    @Override
    public String validate(User user) {
        if (user.getUserName() == null || user.getUserName().isEmpty()) {
            result = MyString.emptyNameError;
        }
        return result;
    }
}
