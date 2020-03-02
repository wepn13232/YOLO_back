package com.sprinboot.dazuoye.dao;

import com.sprinboot.dazuoye.pojo.EssayComment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("essayCommentDao")
@Mapper
public interface essayCommentDao {

    //    插入评论
    @Insert("insert into essayComment(username,name,comment,date,essayId) values(#{username},#{name}," +
            "#{comment},#{date},#{essayId})")
    int insertComment(EssayComment essayComment) throws Exception;

    //    查看评论（最新倒叙）
    @Select("select e.*,u.picUrl from essayComment e , userinfo u where e.username = u.username and e.essayId=#{essayId} order by id desc")
    List<EssayComment> getComment(@Param("essayId") Integer essayId) throws Exception;


    //    删除评论
    @Delete("delete from essayComment where essayId=#{essayId} and id =#{id}")
    int deleteComment(@Param("essayId") Integer essayId, @Param("id") Integer id) throws Exception;

}
