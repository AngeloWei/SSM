package test;

import cn.learn.ssm.dao.UserDao;
import cn.learn.ssm.entity.User;
import org.apache.taglibs.standard.lang.jstl.test.beans.PublicInterface2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration("classpath:spring/spring-dao.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaotest {
    @Autowired
    private UserDao userDao;
    @Test
    public void queryByPhone(){
        User user = userDao.queryByPhone("170234234234");
        System.out.println(user);
    }
    @Test
    public void queryUser(){
        List<User> users = userDao.queryUsers(2, 1);
        for(User user:users){
            System.out.println("+++++++"+user);
        }

    }
    @Test
    public void addScore(){
       // userDao.addSorce(12);
    }
    @Test
    public void  insertUser(){
             User user = new User();
             long start=System.currentTimeMillis();
        for(int i=100;i<500;i++){
            user.setUserName("张三"+i);
            user.setUserPhone("1622343"+i);
            userDao.addUser(user);
        }
            long end = System.currentTimeMillis();
        System.out.println(end-start);

    }
}
