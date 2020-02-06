package com.sprinboot.dazuoye.dao;

import com.sprinboot.dazuoye.pojo.Essay;
import org.apache.ibatis.annotations.*;
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
    @Select("<script>select * from essayinfo <if test='title !=null'>where title like '%${title}%'</if> " +
            "<if test='id!=null'>where id =#{id}</if> </script>")
    List<Essay> getEssay(@Param("title") String title, @Param("id") Integer id) throws Exception;

    //    删除文章
    @Delete("delete from essayinfo where id = #{id}")
    int deleteEssay(@Param("id") Integer id) throws Exception;

    //    获取文章类型
    @Select("select sum(essayType ='1') as typeTravel,sum(essayType='2') as typeStrategy," +
            "sum(essayType='3') as typeLocation,sum(essayType='4') as typePhotoG from essayInfo")
    Essay getEssayType() throws Exception;
}
