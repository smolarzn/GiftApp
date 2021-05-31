package com.natalia.domain.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<Password, String> {

    /**
     * Pattern used to validate password strength.
     * Determines at least one uppercase letter, one lowercase letter
     * and one non-word character.
     */
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*\\W)(?=.*[A-Z])(?=.*[a-z]).{6,}$");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Matcher matcher = PASSWORD_PATTERN.matcher(value);
        return matcher.matches();
    }
}