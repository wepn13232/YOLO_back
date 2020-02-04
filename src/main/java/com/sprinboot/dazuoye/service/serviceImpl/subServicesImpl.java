package com.sprinboot.dazuoye.service.serviceImpl;

import com.sprinboot.dazuoye.dao.subDao;
import com.sprinboot.dazuoye.pojo.Sub;
import com.sprinboot.dazuoye.service.subServices;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class subServicesImpl implements subServices {
    @Resource
    subDao subDao;

    //点赞
    @Override
    public int insertSub(String subUser, Integer picId) throws Exception {
        Sub sub = new Sub();
        sub.setSubUser(subUser);
        sub.setPicId(picId);
        return subDao.insertSub(sub);
    }

    //    获取用户是否点赞
    @Override
    public Sub subOrNot(String subUser, Integer picId) throws Exception {
        Sub sub = new Sub();
        sub = subDao.getSubOrNot(subUser, picId);
        if (sub != null) {
            return sub;
        }
        return null;
    }
}
