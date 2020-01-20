package com.sprinboot.dazuoye.service.serviceImpl;

import com.sprinboot.dazuoye.dao.spaceDao;
import com.sprinboot.dazuoye.pojo.Space;
import com.sprinboot.dazuoye.service.spaceServices;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class spaceServicesImpl implements spaceServices {

    @Resource
    private spaceDao spaceDao;


    @Override
    public List<Space> getSpaceInfo(String username) throws Exception {
        List<Space> space = new ArrayList<>();
        space = spaceDao.getSpaceInfo(username);
        if (space != null) {
            return space;
        }
        return null;
    }


    //    插入空间动态信息
    @Override
    public int insertSpaceInfo(String username, String name, String date, String content) throws Exception {
        Space space = new Space();
        space.setUsername(username);
        space.setName(name);
        space.setDate(date);
        space.setContent(content);
        return spaceDao.insertSpaceInfo(space);
    }


}
