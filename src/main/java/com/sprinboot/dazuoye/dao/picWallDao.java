package com.sprinboot.dazuoye.dao;

import com.sprinboot.dazuoye.pojo.PicWall;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("picWallDao")
@Mapper
public interface picWallDao {

    //    获取全部图片
    @Select("select * from picWall")
    List<PicWall> getAllPicShows() throws Exception;

    //    添加照片
    @Insert("insert into picWall(src,content,username,name) values(#{src},#{content},#{username},#{name})")
    int insertPic(PicWall picWall) throws Exception;

    //    删除照片
    @Delete("delete from picWall where id=#{id}")
    int deletePic(@Param("id") Integer id) throws Exception;
}
