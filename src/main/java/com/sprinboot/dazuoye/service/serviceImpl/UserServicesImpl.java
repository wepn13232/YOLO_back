package com.sprinboot.dazuoye.service.serviceImpl;


import com.sprinboot.dazuoye.dao.UserDao;
import com.sprinboot.dazuoye.pojo.User;
import com.sprinboot.dazuoye.pojo.addressInfo;
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
        user.setPicUrl("https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"); //默认注册头像
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
    public int changeUserInfo(String userSum, String address, String email, String appid, String username,String picUrl) throws Exception {
        User user = new User();
        user.setAppid(appid);
        user.setUserSum(userSum);
        user.setAddress(address);
        user.setEmail(email);
        return userDao.changeUserInfo(userSum, address, email, appid,picUrl,username);
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

    //    admin获取主播信息
    @Override
    public List<User> adminGetHost() throws Exception {
        List<User> users = new ArrayList<>();
        users = userDao.adminGetHost();
        if (users != null) {
            return users;
        }
        return null;
    }

    //    封禁直播
    @Override
    public int banLive(String liveStatus, String username) throws Exception {
        User user = new User();
        user.setLiveStatus(liveStatus);
        return userDao.banLive(liveStatus, username);
    }

    //    查询男女人数
    @Override
    public User getNumOfUserSex() throws Exception {
        User user = new User();
        user = userDao.getNumOfUserSex();
        if (user != null) {
            return user;
        }
        return null;
    }


    //    获取不同地区人数
    @Override
    public List<addressInfo> getAddressNum() throws Exception {
        List<addressInfo> addressInfos = new ArrayList<>();
        addressInfos = userDao.getAdressNum();
        return addressInfos;
    }


}
