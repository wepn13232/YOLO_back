package com.sprinboot.dazuoye.dao;

import com.sprinboot.dazuoye.pojo.Essay;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository("essayDao")
@Mapper
public interface essayDao {

    //    插入文章
    @Insert("insert into essayinfo(title,username,name,date,essayType,content) values(#{title}," +
            "#{username},#{name},#{date},#{essayType},#{content},)")
    int insertEssay(Essay essay) throws Exception;
}
