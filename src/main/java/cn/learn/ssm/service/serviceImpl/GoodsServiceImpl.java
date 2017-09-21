package cn.learn.ssm.service.serviceImpl;

import cn.learn.ssm.dao.GoodsDao;
import cn.learn.ssm.dao.OrderDao;
import cn.learn.ssm.dao.UserDao;
import cn.learn.ssm.entity.Goods;
import cn.learn.ssm.entity.Order;
import cn.learn.ssm.entity.User;
import cn.learn.ssm.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService{

    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private OrderDao orderDao;


    @Override
    public List<Goods> getGoodsByPage(int offset, int limit) {
        return goodsDao.findByPage(offset,limit);
    }

    @Override
    @Transactional
    public void buyGoods( long userId , long goodId) {
        User user = userDao.queryUserById(userId);
        if(user==null){
            //throw exception of  user not exist;
        }
        Order order = new Order();
        order.setgoodId(goodId);
        order.setUserId(userId);
        int orderState = orderDao.createOrder(order);
        if(orderState!=1){
            //throw exception
        }
        int i = goodsDao.reduceNumber(goodId);
        if(i!=1){
         //throw exception
        }

    }
}
