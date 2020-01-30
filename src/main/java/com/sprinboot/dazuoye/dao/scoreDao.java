package com.sprinboot.dazuoye.dao;

import com.sprinboot.dazuoye.pojo.Score;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("scoreDao")
@Mapper
public interface scoreDao {

    //    用户评分打分接口
    @Insert("insert into score(username,score,setedUser,essayID) values(#{username},#{score},#{setedUser},#{essayID})")
    int insertScore(Score score) throws Exception;


    //    获取用户评分接口
    @Select("select score from score where username=#{username}")
    List<Score> getSore(@Param("username") String username) throws Exception;
}
