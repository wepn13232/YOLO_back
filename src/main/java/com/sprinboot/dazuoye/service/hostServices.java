package com.sprinboot.dazuoye.service;

import com.sprinboot.dazuoye.pojo.Host;

public interface hostServices {


    //    开播插入主播信息
    int insertHost(String username, String name, String appid, String title, String roomSum) throws Exception;

    //    获取主播信息
    Host getHostInfo(String username) throws Exception;

}
