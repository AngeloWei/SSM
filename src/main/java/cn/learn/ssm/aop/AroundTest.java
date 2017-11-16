package cn.learn.ssm.aop;

import cn.learn.ssm.dto.BaseResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;


@Component
@Aspect
public class AroundTest {
    @Around("execution(* cn.learn.ssm.web.*.*(..))")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {

        BindingResult result = null;
        for(Object arg:joinPoint.getArgs()){
            if(arg instanceof  BindingResult){
                result= (BindingResult) arg;
            }
        }
        if(result.hasErrors()){
            String errorinfo = result.getFieldError().getField()+result.getFieldError().getDefaultMessage();
            return new BaseResult(false,errorinfo);
        }
        return joinPoint.proceed();
    }
}
