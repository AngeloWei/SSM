package cn.learn.ssm.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResult<T> implements Serializable {

        private static final long serialVersionUID = -4553210301603129878L;
        private boolean success;
        private T data;
        private String message;

        public BaseResult(boolean success,String message){
            this.success=success;
            this.message=message;
        }
        public BaseResult(boolean success,T data){
            this.success=success;
            this.data=data;
        }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "success=" + success +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
