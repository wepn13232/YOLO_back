package com.sprinboot.dazuoye.service;

import com.sprinboot.dazuoye.pojo.PicWall;

import java.util.List;

public interface picWallServices {

    //    获取照片墙全部照片
    List<PicWall> getAllPicShows() throws Exception;

    //    添加照片
    int insertPic(String src, String content, String username, String name) throws Exception;
}
