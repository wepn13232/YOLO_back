package com.sprinboot.dazuoye.dao;


import com.sprinboot.dazuoye.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
@Mapper
public interface UserDao {

    //登录
    @Select("select * from userinfo where username=#{username}")
    User selectAllUser(@Param("username") String username) throws Exception;


    //    注册
    @Insert("insert into userinfo(username,name,password,email,sex,address,liveStatus) values(#{username},#{name},#{password},#{email},#{sex},#{address},#{liveStatus})")
    int addUser(User user) throws Exception;


    //    查询用户信息（展示用，除重要信息）(不传username查全部)
    @Select("<script>select username,name,email,sex,address,liveStatus,userSum,appid from userinfo" +
            "<if test='username!=null'> where username=#{username}</if>" +
            "</script> ")
    List<User> selectSomeUser(@Param("username") String username) throws Exception;


    //    申请直播编码
    @Update("update  userinfo set appid=#{appid} where username=#{username}")
    int addAppId(@Param("appid") String appid, @Param("username") String username) throws Exception;


    //    编辑（更新）用户信息
    @Update("update userinfo set userSum=#{userSum},address=#{address},email=#{email},appid=#{appid} where username=#{username}")
    int changeUserInfo(@Param("userSum") String userSum, @Param("address") String address, @Param("email") String email, @Param("appid") String appid,
                       @Param("username") String username) throws Exception;


}
