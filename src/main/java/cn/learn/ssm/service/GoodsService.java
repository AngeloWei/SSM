package cn.learn.ssm.service;

import cn.learn.ssm.entity.Goods;

import java.util.List;

public interface GoodsService {
    /*
    get goods list
     */
    List<Goods> getGoodsByPage(int offset,int limit);

    /*
    buy goods
     */
    void buyGoods(long userId  ,long goodId);
}
