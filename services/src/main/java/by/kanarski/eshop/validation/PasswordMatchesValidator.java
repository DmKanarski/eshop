package by.kanarski.eshop.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import by.kanarski.eshop.dto.user.NewUserDto;
import by.kanarski.eshop.validation.annotation.PasswordMatches;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, NewUserDto> {

    @Override
    public void initialize(final PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(final NewUserDto user, final ConstraintValidatorContext context) {
        return user.getPassword().equals(user.getPasswordConfirmation());
    }

}
