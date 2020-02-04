package com.sprinboot.dazuoye.dao;

import com.sprinboot.dazuoye.pojo.Sub;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository("subDao")
@Mapper
public interface subDao {

    //    点赞
    @Insert("insert into subTable(subUser,picId) values(#{subUser},#{picId})")
    int insertSub(Sub sub) throws Exception;

    //    获取该用户是否点赞
    @Select("select * from subTable where subUser=#{subUser} and picId=#{picId}")
    Sub getSubOrNot(@Param("subUser") String subUser, @Param("picId") Integer picId) throws Exception;
}
