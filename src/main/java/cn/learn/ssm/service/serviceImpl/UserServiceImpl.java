package cn.learn.ssm.service.serviceImpl;

import cn.learn.ssm.dao.UserDao;
import cn.learn.ssm.entity.User;
import cn.learn.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUserByPage(int offset, int limit) {
        List<User> users = userDao.queryUsers(offset,limit);
        return users;
    }
}
