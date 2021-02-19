package com.zup.cqc.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {UniqueCountryStateValidator.class})
@Target({ ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueCountryState {
    String message() default "{com.zup.cqc.validator.UniqueCountryState}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
    String stateField();
    String countryIdField();
    String countryIdFieldBdAlias();
    Class<?> countryClass();
}
