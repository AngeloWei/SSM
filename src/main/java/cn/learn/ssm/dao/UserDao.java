package cn.learn.ssm.dao;

import cn.learn.ssm.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    /*
        search user by phone
     */

    User queryByPhone(String phone);

    /*
        search User list
     */
    List<User> queryUsers(@Param("offset") int offset,@Param("limit") int limit);

    /*
        add sorce
     */
    void addScore(@Param("number") int number);

    /*
    添加用户
     */
    void addUser(User user);
    /* search user by userId
     */
    User queryUserById(@Param("userId") long userId);
}
