package cc.somkiat.basicunittesting.validation;

import cc.somkiat.basicunittesting.model.User;

public abstract class ValidationRule {
    protected String result = "สำเร็จ!";

    public abstract String validate(User user);
}
