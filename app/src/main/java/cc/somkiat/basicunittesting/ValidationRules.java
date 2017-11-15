package cc.somkiat.basicunittesting;

import java.util.ArrayList;

import cc.somkiat.basicunittesting.model.MyString;
import cc.somkiat.basicunittesting.model.User;
import cc.somkiat.basicunittesting.validation.*;

public class ValidationRules {
    ArrayList<ValidationRule> rules;

    public ValidationRules() {
        rules = new ArrayList<>();

        rules.add(new EmptyNameValidation());
        rules.add(new NameLengthValidation());
    }

    public String validate(User user) {
        String result = "";

        for (ValidationRule rule : rules) {
            String message = rule.validate(user);
            if (message != MyString.success) {
                result = message;
                break;
            }
        }

        return result;
    }
}
