package com.natalia.domain.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<Password, String> {

    private final Pattern atLeastSixSigns = Pattern.compile("\\S{6,}");
    private final Pattern atLeastOneBigLetter = Pattern.compile("[A-Z]+");
    private final Pattern atLeastOneSignNotLetter = Pattern.compile("\\W+");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Matcher atLeastSixSignsMatcher = atLeastSixSigns.matcher(value);
        Matcher atLeastOneBigLetterMatcher = atLeastOneBigLetter.matcher(value);
        Matcher atLeastOneSignNotLetterMatcher = atLeastOneSignNotLetter.matcher(value);
        return atLeastOneSignNotLetterMatcher.matches() && atLeastOneBigLetterMatcher.matches() && atLeastSixSignsMatcher.matches();
    }
}