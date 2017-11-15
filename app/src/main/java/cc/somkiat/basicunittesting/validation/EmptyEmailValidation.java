package cc.somkiat.basicunittesting.validation;

import cc.somkiat.basicunittesting.model.MyString;
import cc.somkiat.basicunittesting.model.User;

public class EmptyEmailValidation extends ValidationRule {

    @Override
    public String validate(User user) {
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            result = MyString.emptyEmailError;
        }
        return result;
    }
}
