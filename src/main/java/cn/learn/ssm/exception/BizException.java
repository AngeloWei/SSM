package cn.learn.ssm.exception;

public class BizException extends  RuntimeException{


    private static final long serialVersionUID = 2618539011018241948L;

    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }
}
