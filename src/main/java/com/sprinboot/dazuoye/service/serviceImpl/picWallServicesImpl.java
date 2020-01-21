package com.sprinboot.dazuoye.service.serviceImpl;


import com.sprinboot.dazuoye.dao.picWallDao;
import com.sprinboot.dazuoye.pojo.PicWall;
import com.sprinboot.dazuoye.service.picWallServices;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class picWallServicesImpl implements picWallServices {

    @Resource
    private picWallDao picWallDao;


    //    获取照片墙全部照片
    @Override
    public List<PicWall> getAllPicShows() throws Exception {
        List<PicWall> picWalls = new ArrayList<>();
        picWalls = picWallDao.getAllPicShows();
        return picWalls;
    }


//    添加照片
    @Override
    public int insertPic(String src, String content, String username, String name) throws Exception {
        PicWall picWall = new PicWall();
        picWall.setSrc(src);
        picWall.setContent(content);
        picWall.setUsername(username);
        picWall.setName(name);
        return picWallDao.insertPic(picWall);
    }
}
