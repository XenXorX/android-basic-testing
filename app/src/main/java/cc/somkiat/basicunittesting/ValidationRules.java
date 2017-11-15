package cc.somkiat.basicunittesting;

import java.util.ArrayList;

import cc.somkiat.basicunittesting.model.User;
import cc.somkiat.basicunittesting.validation.EmptyValidation;
import cc.somkiat.basicunittesting.validation.ValidationRule;

public class ValidationRules {
    ArrayList<ValidationRule> rules;

    public ValidationRules() {
        rules = new ArrayList<>();

        rules.add(new EmptyValidation());
    }

    public String validate(User user) {
        String result = "";

        for (ValidationRule rule : rules) {
            String message = rule.validate(user);
            if (message != "สำเร็จ") {
                result = message;
                break;
            }
        }

        return result;
    }
}
