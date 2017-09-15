package test;

import cn.learn.ssm.dao.OrderDao;
import cn.learn.ssm.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class OrderDaotest {
    @Autowired
    private OrderDao orderDao;

    @Test
    public  void createOrdertest(){
        Order order = new Order();
        order.setTitle("buy good success");
        order.setUserId(10000);
        order.setgoodId(1000);
        int order1 = orderDao.createOrder(order);
        System.out.println(order1);
    }
    @Test
    public void searchOrderByUserId(){
        List<Order> orders = orderDao.searchOrderByUserId(10000);
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
