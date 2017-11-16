package test;

import cn.learn.ssm.cache.RedisCache;
import cn.learn.ssm.entity.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/spring-redis.xml")
public class RedisCacheTest {
    @Autowired
    public RedisCache redisCache;

    @Test
    public void setUserTest() {
        if (redisCache.setCache("user1", "nihao")) {
            System.out.println("set success");
        }
        redisCache.setCacheNoReturn("user2", "user2");
        redisCache.setCache("userObj", new User(123444, "name1", "1704223213", 123));
        redisCache.setCacheWithExpireTime("userObj1", new User(12323, "name2", "1232332", 132), 600);
        List<User> list = new ArrayList<User>();

        User user1 = new User(123444, "name1", "1704223213", 123);
        User user2 = new User(1234441, "name1", "1704223213", 123);
        list.add(user1);
        list.add(user2);
        redisCache.setCacheList("userList", list);
        redisCache.pushCacheListByOne("pushCacheList", user1);
        redisCache.pushCacheListByOne("pushCacheList", user2);
    }
    @Test
    public void getValueOfRedis() {
        String user1 = redisCache.getCache("user1");
        User userObj = redisCache.getCache("userObj", new User().getClass());
        List<User> userList = (List<User>) redisCache.getCacheList("userList", new User().getClass());
        List<? extends User> pushCacheList = redisCache.getCacheListByAll("pushCacheList", new User().getClass());
        System.out.println(user1.toString());
        System.out.println(userObj.toString());
        System.out.println(userList.get(0).toString());
        System.out.println(pushCacheList.get(0).toString());
    }
}
