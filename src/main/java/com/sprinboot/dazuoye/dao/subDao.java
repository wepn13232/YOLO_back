package com.sprinboot.dazuoye.dao;

import com.sprinboot.dazuoye.pojo.Sub;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository("subDao")
@Mapper
public interface subDao {

    //    点赞
    @Insert("insert into subTable(subUser,picId) values(#{subUser},#{picId})")
    int insertSub(Sub sub) throws Exception;

    //    取消点赞
    @Delete("delete from subTable where picId=#{picId} and subUser=#{subUser}")
    int cancelSub(@Param("picId") Integer picId, @Param("subUser") String subUser) throws Exception;

    //    获取该用户是否点赞
    @Select("select * from subTable where subUser=#{subUser} and picId=#{picId}")
    Sub getSubOrNot(@Param("subUser") String subUser, @Param("picId") Integer picId) throws Exception;

    //    获取某照片的点赞人数
    @Select("select count(*) as subCount from subTable where picId=#{pidId}")
    Sub getSubCount(@Param("pidId") Integer picId) throws Exception;
}
