package com.natalia.domain.validator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordValidatorTest {

    private final PasswordValidator passwordValidator = new PasswordValidator();

    @ParameterizedTest(name = "#{index} - Tested password = {0}")
    @MethodSource("validPasswordProvider")
    void passwordValidationTrue(String password) {
        assertTrue(passwordValidator.isValid(password, null));
    }

    @ParameterizedTest(name = "#{index} - Tested password = {0}")
    @MethodSource("nonValidPasswordProvider")
    void passwordValidationFalse(String password) {
        assertFalse(passwordValidator.isValid(password, null));
    }

    static Stream<String> validPasswordProvider() {
        return Stream.of(
                "Abcde.",
                "!Password",
                "+plus-minuS",
                "ValidPass*"
        );
    }

    static Stream<String> nonValidPasswordProvider() {
        return Stream.of(
                "abcdef",
                "ABCDEF",
                "abcdE2",
                "Aa.",
                "!@#$%^",
                "ASDF.-"
        );
    }

}