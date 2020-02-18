package com.sprinboot.dazuoye.service;

import com.sprinboot.dazuoye.pojo.EssayComment;

import java.util.List;

public interface essayCommentServices {

    //    评论
    int insertComment(String username, String name, String comment, String date, Integer essayId) throws Exception;

    //    查看评论
    List<EssayComment> getComment(Integer essayId) throws Exception;
}
