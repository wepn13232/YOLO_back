package com.sprinboot.dazuoye.dao;

import com.sprinboot.dazuoye.pojo.Sub;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository("subDao")
@Mapper
public interface subDao {

    //    点赞
    @Insert("insert into subTable(subUser,picId) values(#{subUser},#{picId})")
    int insertSub(Sub sub) throws Exception;
}
