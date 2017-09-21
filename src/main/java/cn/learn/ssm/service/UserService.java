package cn.learn.ssm.service;

import cn.learn.ssm.entity.User;

import java.util.List;

public interface UserService {
    /*
    get User list
     */
    List<User> getUserByPage(int offset,int limit);
}
