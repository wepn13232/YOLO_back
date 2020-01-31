package com.sprinboot.dazuoye.dao;

import com.sprinboot.dazuoye.pojo.Host;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("hostDao")
@Mapper
public interface hostDao {

    //    开播插入开播主播信息
    @Insert("insert into host(username,name,appid,title,roomSum) values(#{username},#{name},#{appid},#{title},#{roomSum})")
    int insertHost(Host host) throws Exception;

    //    获取主播信息
    @Select("<script>" +
            "select * from host<if test='username!=null'>where username=#{username}</if> " +
            " </script>")
    List<Host> getHostInfo(@Param("username") String username) throws Exception;
}
