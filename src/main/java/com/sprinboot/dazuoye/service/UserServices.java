package com.sprinboot.dazuoye.service;

import com.sprinboot.dazuoye.pojo.User;

import java.util.List;

public interface UserServices {

    //    查询用户
    User getUser(String username, String password) throws Exception;


    //    增加用户（用户注册）
    int addUser(String username, String name, String password, String sex, String email, String address) throws Exception;

}
