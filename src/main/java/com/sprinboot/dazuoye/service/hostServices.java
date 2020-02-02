package com.sprinboot.dazuoye.service;

import com.sprinboot.dazuoye.pojo.Host;

import java.util.List;

public interface hostServices {


    //    申请appid时插入开播主播信息
    int insertHost(String username, String name, String appid, String title, String roomSum) throws Exception;

    //    获取主播信息
    List<Host> getHostInfo(String username) throws Exception;

    //    admin获取主播信息
    List<Host> adminGetHostInfo(String username) throws Exception;

    //    开播更新主播信息表
    int updateHostInfo(String title, String roomSum, Integer isLive ,String username) throws Exception;

    //    获取是否开播状态
    Host getIsLive(String username) throws Exception;

}
