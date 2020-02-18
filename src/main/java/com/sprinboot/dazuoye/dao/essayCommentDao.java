package com.sprinboot.dazuoye.dao;

import com.sprinboot.dazuoye.pojo.EssayComment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("essayCommentDao")
@Mapper
public interface essayCommentDao {

    //    插入评论
    @Insert("insert into essayComment(username,name,comment,date,essayId) values(#{username},#{name}," +
            "#{comment},#{date},#{essayId})")
    int insertComment(EssayComment essayComment) throws Exception;

    //    查看评论
    @Select("select * from essayComment where essayId=#{essayId}")
    List<EssayComment> getComment(@Param("essayId") Integer essayId) throws Exception;
}
