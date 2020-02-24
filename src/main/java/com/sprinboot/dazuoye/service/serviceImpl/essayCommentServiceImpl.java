package com.sprinboot.dazuoye.service.serviceImpl;

import com.sprinboot.dazuoye.pojo.Essay;
import com.sprinboot.dazuoye.pojo.EssayComment;
import com.sprinboot.dazuoye.service.essayCommentServices;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class essayCommentServiceImpl implements essayCommentServices {
    @Resource
    com.sprinboot.dazuoye.dao.essayCommentDao essayCommentDao;

    //    评论
    @Override
    public int insertComment(String username, String name, String comment, String date, Integer essayId) throws Exception {
        EssayComment essayComment = new EssayComment();
        essayComment.setUsername(username);
        essayComment.setName(name);
        essayComment.setComment(comment);
        essayComment.setDate(date);
        essayComment.setEssayId(essayId);
        return essayCommentDao.insertComment(essayComment);
    }


    //    获取评论
    @Override
    public List<EssayComment> getComment(Integer essayId) throws Exception {
        List<EssayComment> essayComments = new ArrayList<>();
        essayComments = essayCommentDao.getComment(essayId);
        return essayComments;
    }


    //    删除评论
    @Override
    public int deleteComment(Integer essayId, Integer id) throws Exception {
        return essayCommentDao.deleteComment(essayId, id);
    }


}
