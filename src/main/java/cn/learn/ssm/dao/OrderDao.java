package cn.learn.ssm.dao;

import cn.learn.ssm.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDao {

        /*
        create order
         */
        int createOrder(Order order);

        /*
        search order by phone
         */
        List<Order> searchOrderByUserId(@Param("userId")long userId);

}
