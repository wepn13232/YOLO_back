package com.sprinboot.dazuoye.dao;

import com.sprinboot.dazuoye.pojo.Host;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("hostDao")
@Mapper
public interface hostDao {

    //    申请appid时插入开播主播信息
    @Insert("insert into host(username,name,appid,title,roomSum,isLive) values(#{username},#{name},#{appid},#{title},#{roomSum},#{isLive})")
    int insertHost(Host host) throws Exception;

    //    获取主播信息
    @Select("<script>" +
            "select * from host<if test='username!=null'>where username=#{username}</if> " +
            " </script>")
    List<Host> getHostInfo(@Param("username") String username) throws Exception;

    //    开播更新主播信息表内容
    @Update("update host set title=#{title} , roomSum=#{roomSum} where username=#{username}")
    int updateHostInfo(@Param("title") String title, @Param("roomSum") String roomSum, @Param("username") String username) throws Exception;

    //    获取是否开播状态
    @Select("select isLive from host where username=#{username}")
    Host getIsLive(@Param("username") String username) throws Exception;

}
