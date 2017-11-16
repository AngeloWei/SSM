package cn.learn.ssm.web.paramEntity;

import cn.learn.ssm.validation.Not100;

import javax.validation.constraints.Min;

public class UserList1 {
    @Min(value = 30,message = "{user.name.error}")
    @Not100
    private int limit;
    private int offset;


    @Override
    public String toString() {
        return "UserList1{" +
                "limit=" + limit +
                ", offset=" + offset +
                '}';
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
