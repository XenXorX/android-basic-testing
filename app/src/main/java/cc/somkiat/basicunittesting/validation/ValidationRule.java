package cc.somkiat.basicunittesting.validation;

import cc.somkiat.basicunittesting.model.User;

public interface ValidationRule {
    boolean validate(User user);
    String getErrorMessage();
}
