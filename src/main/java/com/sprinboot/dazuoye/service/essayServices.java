package com.sprinboot.dazuoye.service;

import com.sprinboot.dazuoye.pojo.Essay;
import org.springframework.stereotype.Service;

import java.util.List;

public interface essayServices {
    //    模糊查询文章
    List<Essay> getEssay(String title, Integer id) throws Exception;

    //    插入文章
    int insertEssay(String title, String username, String name, String date, String essayType, String content, String url, String OTitle) throws Exception;
}
