package com.springmvc.springmvcexcercise.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneNumberValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneNumber {
    String message() default "The phonenumber must match xxx/xxxxxx, xxxx/xxxxxx, +xxxx/xxxxxx or +xxxxx/xxxxxx";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
