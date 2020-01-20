package com.sprinboot.dazuoye.service;

import com.sprinboot.dazuoye.pojo.Space;

import java.util.List;

public interface spaceServices {

    //    获取空间动态信息
    List<Space> getSpaceInfo(String username) throws Exception;

    //    插入空间动态信息
    int insertSpaceInfo(String username,String name,String date,String content) throws Exception;
}
