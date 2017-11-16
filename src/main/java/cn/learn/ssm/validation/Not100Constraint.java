package cn.learn.ssm.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Not100Constraint implements ConstraintValidator<Not100,Long>{

    @Override
    public void initialize(Not100 constraintAnnotation) {

    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if(value == 100){
            return true;
        }
        return false;
    }
}
