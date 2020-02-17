package com.sprinboot.dazuoye.service;

import com.sprinboot.dazuoye.pojo.Sub;

public interface subServices {

    //    点赞
    int insertSub(String subUser, Integer picId) throws Exception;

    //    取消点赞
    int cancelSub(Integer picId,String subUser) throws Exception;

    //    获取用户是否有点赞
    Sub subOrNot(String subUser, Integer picId) throws Exception;

//    获取照片点赞的人数
    Sub getSubCount(Integer picId) throws Exception;
}
