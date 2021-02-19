package com.zup.cqc.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {CPForCNPJValidator.class})
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CPForCNPJ {
    String message() default "{com.zup.cqc.validator.CPForCNPJ}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
