package cn.learn.ssm.dao;

import cn.learn.ssm.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsDao {
    /*
        get goods list
     */
     List<Goods> findByPage(@Param("offset") int offset,@Param("limit")int limit);

    /*
     gooods_number=goods_number-1;
     */
     int reduceNumber(long goodId);

     int insertGoods(Goods goods);
}
