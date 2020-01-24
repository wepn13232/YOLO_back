package com.sprinboot.dazuoye.service;

import com.sprinboot.dazuoye.pojo.User;

import java.util.List;

public interface UserServices {

    //    查询用户
    User getUser(String username, String password) throws Exception;


    //    增加用户（用户注册）
    int addUser(String username, String name, String password, String sex, String email, String address) throws Exception;

    //  查询用户
    List<User> selectSomeUser(String username) throws Exception;

    //    根据昵称查询用户
    User selectUserByName(String name) throws Exception;

    //    申请直播编码
    int addAppId(String appid, String username) throws Exception;

    //    编辑（更新用户信息）
    int changeUserInfo(String userSum, String address, String email, String appid, String username) throws Exception;

}
