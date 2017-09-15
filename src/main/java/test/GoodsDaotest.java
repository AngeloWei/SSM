package test;

import cn.learn.ssm.dao.GoodsDao;
import cn.learn.ssm.entity.Goods;
import org.apache.taglibs.standard.tag.common.core.ForEachSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@ContextConfiguration("classpath:spring/spring-dao.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class GoodsDaotest {
    @Autowired
    private GoodsDao goodsDao;
    @Test
    public void findByPage(){
        List<Goods> goods = goodsDao.findByPage(3, 10);
        for (Goods good :goods){
            System.out.println(good);
        }
    }
    @Test
    public void insertGoods(){
        Goods goods = new Goods();
        for(int i=0;i<100;i++) {
            goods.setPrice(1212.2f);
            goods.setState((short) 1);
            goods.setTitle("苹果"+i);
            goods.setNumber(200);
            goodsDao.insertGoods(goods);
        }
    }
    @Test
    public void reduceNumber(){
        int i = goodsDao.reduceNumber(1000);
        System.out.println(i);
    }
}
