package com.sprinboot.dazuoye.dao;

import com.sprinboot.dazuoye.pojo.Essay;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("essayDao")
@Mapper
public interface essayDao {

    //    插入文章
    @Insert("insert into essayinfo(title,username,name,date,essayType,content,url,OTitle) values(#{title}," +
            "#{username},#{name},#{date},#{essayType},#{content},#{url},#{OTitle})")
    int insertEssay(Essay essay) throws Exception;

    //    查看文章（可根据文章名字查看）-模糊查询
    @Select("<script>select * from essayinfo <if test='title !=null'>where title = '%#{title}%'</if> </script>")
    List<Essay> getEssay(@Param("title")String title) throws Exception;
}
