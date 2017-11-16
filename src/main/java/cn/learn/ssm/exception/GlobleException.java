package cn.learn.ssm.exception;


import cn.learn.ssm.dto.BaseResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.http.converter.HttpMessageConversionException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class GlobleException {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)

    @ResponseBody
    public BaseResult<String> globleException(Exception e){
        BaseResult baseResult=null;
        String message= e.getMessage()+"StackTraceMessage:"+e.getClass().getName();
        if(e instanceof HttpMessageConversionException){
            baseResult = new BaseResult(false, "数据类型异常,请检查参数");
        }
        else
            baseResult = new BaseResult(false,message);
        return baseResult;
    }
}
