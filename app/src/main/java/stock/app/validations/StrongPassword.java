package stock.app.validations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import stock.app.validators.StrongPasswordValidation;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StrongPasswordValidation.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface StrongPassword {

    String message() default "Please provide strong password!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
