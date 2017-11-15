package cc.somkiat.basicunittesting.validation;

import cc.somkiat.basicunittesting.model.MyString;
import cc.somkiat.basicunittesting.model.User;

public class NameLengthValidation extends ValidationRule {

    @Override
    public String validate(User user) {
        if (user.getUserName().length() < 2 || user.getUserName().length() > 20) {
            result = MyString.nameLengthError;
        }
        return result;
    }
}
