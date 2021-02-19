package com.zup.cqc.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {ValidIdValidator.class})
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidId {
    String message() default "{com.zup.cqc.validator.ValidId}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
    Class<?> domainClass();
}
