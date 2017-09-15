package cn.learn.ssm.entity;

import java.util.Date;

public class Order {
    private  long orderId;
    private  long userId;
    private Date creatTime;
   
    private String title;
    private long goodId;

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", creatTime=" + creatTime +
                ", title='" + title + '\'' +
                ", goodId=" + goodId +
                '}';
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getgoodId() {
        return goodId;
    }

    public void setgoodId(long goodId) {
        this.goodId = goodId;
    }
}
