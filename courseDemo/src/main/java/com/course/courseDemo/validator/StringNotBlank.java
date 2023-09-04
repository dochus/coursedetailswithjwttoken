package com.course.courseDemo.validator;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import org.apache.commons.lang3.StringUtils;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StringNotBlank.StringNotBlankValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface StringNotBlank {
  String message() default "Field should not be empty or null";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  class StringNotBlankValidator implements ConstraintValidator<StringNotBlank, String> {

    @Override
    public void initialize(StringNotBlank context) {
      // This method block is not used because we don't have to manipulate any thing from incoming
      // data.
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
      return StringUtils.isNotBlank(value);
    }
  }
}
