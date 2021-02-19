package com.zup.cqc.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {ValidCountryStateValidator.class})
@Target({ ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCountryState {
    String message() default "{com.zup.cqc.validator.ValidState}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
    Class<?> stateClass();
    String stateIdField();
    Class<?> countryClass();
    String countryIdField();
    String countryEntityField();
}
