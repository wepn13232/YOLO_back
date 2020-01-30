package com.sprinboot.dazuoye.service;

import com.sprinboot.dazuoye.pojo.Score;

import java.util.List;

public interface scoreServices {
    //    用户等级打分
    int insertScore(String username, String score,String setedUser,Integer essayID) throws Exception;

    //    获取用户评分
    List<Score> getScore(String username) throws Exception;
}

