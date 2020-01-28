package com.sprinboot.dazuoye.service.serviceImpl;

import com.sprinboot.dazuoye.dao.essayDao;
import com.sprinboot.dazuoye.pojo.Essay;
import com.sprinboot.dazuoye.service.essayServices;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class essayServicesImpl implements essayServices {
    @Resource
    private essayDao essayDao;


    //    模糊查询用户
    @Override
    public List<Essay> getEssay(String title) throws Exception {
        List<Essay> essays = new ArrayList<>();
        essays = essayDao.getEssay(title);
        if (essays != null) {
            return essays;
        }
        return null;
    }

    @Override
    public int insertEssay(String title, String username, String name, String date, String essayType, String content,String url) throws Exception {
        Essay essay = new Essay();
        essay.setTitle(title);
        essay.setUsername(username);
        essay.setName(name);
        essay.setDate(date);
        essay.setEssayType(essayType);
        essay.setContent(content);
        essay.setUrl(url);
        return essayDao.insertEssay(essay);
    }
}
