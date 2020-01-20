package com.sprinboot.dazuoye.dao;

import com.sprinboot.dazuoye.pojo.Space;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("spaceDao")
@Mapper
public interface spaceDao {

    //    查询具体用户空间动态
    @Select("select * from spaceInfo where username=#{username} order by date DESC")
    List<Space> getSpaceInfo(@Param("username") String username) throws Exception;


    //    插入空间动态
    @Insert("insert into spaceInfo(username,name,date,content) values(#{username},#{name},#{date},#{content})")
    int insertSpaceInfo(Space space) throws Exception;
}
