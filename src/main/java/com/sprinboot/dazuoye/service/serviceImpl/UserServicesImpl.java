package com.sprinboot.dazuoye.service.serviceImpl;


import com.sprinboot.dazuoye.dao.UserDao;
import com.sprinboot.dazuoye.pojo.User;
import com.sprinboot.dazuoye.service.UserServices;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServicesImpl implements UserServices {

    @Resource
    private UserDao userDao;


    //用户登录
    @Override
    public User getUser(String username, String password) throws Exception {
        User user = null;
        user = userDao.selectAllUser(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }


    //    用户注册
    @Override
    public int addUser(String username, String name, String password, String sex, String email, String address) throws Exception {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setAddress(address);
        user.setEmail(email);
        user.setSex(sex);
        user.setName(name);
        user.setLiveStatus("0"); //默认0，申请了直播编码才可以开
        return userDao.addUser(user);
    }


}
