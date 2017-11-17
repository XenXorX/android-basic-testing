package cc.somkiat.basicunittesting;

import java.util.ArrayList;

import cc.somkiat.basicunittesting.model.User;
import cc.somkiat.basicunittesting.validation.*;

public class ValidationRules {
    public static final String success = "สำเร็จ!";

    private ArrayList<ValidationRule> rules;

    public ValidationRules() {
        rules = new ArrayList<>();

        rules.add(new EmptyNameValidation());
        rules.add(new NameLengthValidation());
        rules.add(new SpecialNameValidation());
        rules.add(new EmptyEmailValidation());
        rules.add(new EmailPatternValidation());
    }

    public String validate(User user) {
        for (ValidationRule rule : rules) {
            if (rule.validate(user)) {
                return rule.getErrorMessage();
            }
        }
        return success;
    }
}
