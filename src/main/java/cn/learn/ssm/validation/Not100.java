package cn.learn.ssm.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Target({ElementType.METHOD,ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = Not100Constraint.class)
@Documented
public @interface Not100 {
    String message() default "{cn.learn.ssm.validation.Not100}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
