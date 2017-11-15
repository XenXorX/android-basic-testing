package cc.somkiat.basicunittesting.validation;

import java.util.regex.Pattern;

import cc.somkiat.basicunittesting.model.MyString;
import cc.somkiat.basicunittesting.model.User;

public class EmailPatternValidation extends ValidationRule {
    private String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    public String validate(User user) {
        if(!Pattern.matches(emailPattern, user.getEmail())) {
            result = MyString.emailPatternError;
        }
        return result;
    }
}
