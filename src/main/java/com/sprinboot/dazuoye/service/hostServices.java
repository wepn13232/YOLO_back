package com.sprinboot.dazuoye.service;

import com.sprinboot.dazuoye.pojo.Host;

import java.util.List;

public interface hostServices {


    //    申请appid时插入开播主播信息
    int insertHost(String username, String name, String appid, String title, String roomSum) throws Exception;

    //    获取主播信息
    List<Host> getHostInfo(String username) throws Exception;

    //    开播更新主播信息表
    int updateHostInfo(String title, String roomSum, String username) throws Exception;

}
