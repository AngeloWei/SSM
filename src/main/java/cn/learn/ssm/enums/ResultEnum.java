package cn.learn.ssm.enums;
/*
枚举类 ,定义错误码
 */

public enum ResultEnum {

    //database error 10
    DATA_BASE_INSERT(101,"insert error"),
    DATA_BASE_UPDATE(102,"update error"),
    DATE_BASE_SELECT(103,"SELELCT NULL"),
    //用户相关11
    USER_INVALIABLE(111,"user not exist");

   private int code;
   private String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;

    }
}
