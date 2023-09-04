package com.course.courseDemo.validator;

import jakarta.validation.Constraint;
import jakarta.validation.OverridesAttribute;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Pattern(regexp = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$")
@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {})
public @interface ValidEmail {
  @OverridesAttribute(constraint = Pattern.class, name = "message")
  String message() default "Invalid email address value";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
