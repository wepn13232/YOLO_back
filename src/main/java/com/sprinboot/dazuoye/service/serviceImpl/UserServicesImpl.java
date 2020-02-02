package com.sprinboot.dazuoye.service.serviceImpl;


import com.sprinboot.dazuoye.dao.UserDao;
import com.sprinboot.dazuoye.pojo.User;
import com.sprinboot.dazuoye.service.UserServices;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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


    //    查询具体用户
    @Override
    public List<User> selectSomeUser(String username) throws Exception {
        List<User> user = new ArrayList<>();
        user = userDao.selectSomeUser(username);
        if (user != null) {
            return user;
        }
        return null;
    }


    //    根据用户昵称查询用户
    @Override
    public User selectUserByName(String name) throws Exception {
        User user = null;
        user = userDao.selectUserByName(name);
        if (user != null) {
            return user;
        }
        return null;
    }


    //    申请直播编码
    @Override
    public int addAppId(String appid, String username) throws Exception {
        User user = new User();
        user.setAppid(appid);
        user.setLiveStatus("1");
        return userDao.addAppId(appid, username);
    }


    //    编辑（更新）用户信息
    @Override
    public int changeUserInfo(String userSum, String address, String email, String appid, String username) throws Exception {
        User user = new User();
        user.setAppid(appid);
        user.setUserSum(userSum);
        user.setAddress(address);
        user.setEmail(email);
        return userDao.changeUserInfo(userSum, address, email, appid, username);
    }


    //    查询appid
    @Override
    public User selectAppid(String username) throws Exception {
        User user = new User();
        user = userDao.selectAppid(username);
        if (user != null) {
            return user;
        }
        return null;
    }


}
