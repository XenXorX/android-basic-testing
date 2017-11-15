package cc.somkiat.basicunittesting.validation;

import java.util.regex.Pattern;

import cc.somkiat.basicunittesting.model.MyString;
import cc.somkiat.basicunittesting.model.User;

public class SpecialNameValidation extends ValidationRule {

    @Override
    public String validate(User user) {
        if (!Pattern.matches("^[a-zA-Z]+$", user.getUserName())) {
            result = MyString.specialNameError;
        }
        return result;
    }
}
