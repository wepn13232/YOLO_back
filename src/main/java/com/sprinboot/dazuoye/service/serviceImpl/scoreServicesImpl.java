package com.sprinboot.dazuoye.service.serviceImpl;

import com.sprinboot.dazuoye.dao.scoreDao;
import com.sprinboot.dazuoye.pojo.Score;
import com.sprinboot.dazuoye.service.scoreServices;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class scoreServicesImpl implements scoreServices {
    @Resource
    private scoreDao scoreDao;


    //    用户等级打分
    @Override
    public int insertScore(String username, String score,String setedUser,Integer essayID) throws Exception {
        Score score1 = new Score();
        score1.setUsername(username);
        score1.setScore(score);
        score1.setSetedUser(setedUser);
        score1.setEssayID(essayID);
        return scoreDao.insertScore(score1);
    }


    //    获取用户评分
    @Override
    public List<Score> getScore(String username) throws Exception {
        List<Score> scores = scoreDao.getSore(username);
        if (scores != null) {
            return scores;
        }
        return null;
    }
}
