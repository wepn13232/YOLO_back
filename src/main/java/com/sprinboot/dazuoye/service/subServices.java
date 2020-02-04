package com.sprinboot.dazuoye.service;

import com.sprinboot.dazuoye.pojo.Sub;

public interface subServices {

    //    点赞
    int insertSub(String subUser, Integer picId) throws Exception;

    //    获取用户是否有点赞
    Sub subOrNot(String subUser, Integer picId) throws Exception;
}
