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


    //    模糊查询文章
    @Override
    public List<Essay> getEssay(String title, Integer id) throws Exception {
        List<Essay> essays = new ArrayList<>();
        essays = essayDao.getEssay(title, id);
        if (essays != null) {
            return essays;
        }
        return null;
    }

    @Override
    public int insertEssay(String title, String username, String name, String date, String essayType, String content, String url, String OTitle) throws Exception {
        Essay essay = new Essay();
        essay.setTitle(title);
        essay.setUsername(username);
        essay.setName(name);
        essay.setDate(date);
        essay.setEssayType(essayType);
        essay.setContent(content);
        essay.setUrl(url);
        essay.setOTitle(OTitle);
        return essayDao.insertEssay(essay);
    }
}
