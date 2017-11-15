package cc.somkiat.basicunittesting.validation;

import cc.somkiat.basicunittesting.model.MyString;
import cc.somkiat.basicunittesting.model.User;

public abstract class ValidationRule {
    protected String result = MyString.success;

    public abstract String validate(User user);
}
