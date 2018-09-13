package ru.javawebinar.topjava.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.javawebinar.topjava.service.UserService;
import ru.javawebinar.topjava.to.UserTo;

@Component
public class UserFormValidator implements Validator {

    private final UserService userService;

    @Autowired
    public UserFormValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return UserTo.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserTo user = (UserTo) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "just test message", "just test message");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "just test message", "just test message");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "just test message", "just test message");

        if (user.getEmail().isEmpty()) {
            System.out.println("email is required");
            errors.rejectValue("email", "Email is required", "Email is required");
        } else if (userService.getByEmail(user.getEmail()) != null) {
            System.out.println("duplicate email");
            errors.rejectValue("email", "User with this email already exists", "User with this email already exists");
        }
    }
}
