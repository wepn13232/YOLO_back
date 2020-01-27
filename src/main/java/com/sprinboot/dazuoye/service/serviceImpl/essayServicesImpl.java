package com.sprinboot.dazuoye.service.serviceImpl;

import com.sprinboot.dazuoye.dao.essayDao;
import com.sprinboot.dazuoye.pojo.Essay;
import com.sprinboot.dazuoye.service.essayServices;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class essayServicesImpl implements essayServices {
    @Resource
    private essayDao essayDao;


    @Override
    public int insertEssay(String title, String username, String name, String date, String essayType, String content) throws Exception {
        Essay essay = new Essay();
        essay.setTitle(title);
        essay.setUsername(username);
        essay.setName(name);
        essay.setDate(date);
        essay.setEssayType(essayType);
        essay.setContent(content);
        return essayDao.insertEssay(essay);
    }
}
