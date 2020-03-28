package com.sprinboot.dazuoye.service;

import com.sprinboot.dazuoye.pojo.Host;
import com.sprinboot.dazuoye.pojo.User;
import com.sprinboot.dazuoye.pojo.addressInfo;

import java.util.List;

public interface UserServices {

    //    查询用户（登录用）
    User getUser(String username, String password) throws Exception;


    //    增加用户（用户注册）
    int addUser(String username, String name, String password, String sex, String email, String address,Integer quyestionT,String questionC) throws Exception;

    //  查询用户具体信息
    List<User> selectSomeUser(String username) throws Exception;

    //    根据昵称查询用户
    User selectUserByName(String name) throws Exception;

    //    申请直播编码
    int addAppId(String appid, String username) throws Exception;

    //    编辑（更新用户信息）
    int changeUserInfo(String userSum, String address, String email, String appid, String username, String picUrl) throws Exception;

    //    查询appid
    User selectAppid(String username) throws Exception;

    //    admin获取主播信息
    List<Host> adminGetHost() throws Exception;

    //    封禁直播
    int banLive(String liveStatus, String username) throws Exception;

    //    查询男女人数（admin）展示
    User getNumOfUserSex() throws Exception;

    //    获取不同地区人数比例
    List<addressInfo> getAddressNum() throws Exception;

    //    更新用户分数
    int updateUserScore(String userScore, String username) throws Exception;

    //    根据用户评分获取用户
    List<User> getUserByScore() throws Exception;

    //    admin模糊查询用户
    List<Host> adminGetHostByFuzzy(String name) throws Exception;

    //    重置前确认用户信息
    User userConfirm(String username, String name, String email, Integer questionT, String questionC) throws Exception;

    //    重置密码
    int resetPassword(String password,String username) throws Exception;
}
