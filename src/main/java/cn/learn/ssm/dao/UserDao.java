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
    void addSorce(@Param("number") int number,@Param("userId")int userId);

    /*
    添加用户
     */
    void addUser(User user);
}
