package com.sprinboot.dazuoye.service;

import com.sprinboot.dazuoye.pojo.Essay;
import org.springframework.stereotype.Service;

public interface essayServices {
    //    插入文章
    int insertEssay(String title, String username, String name, String date, String essayType, String content) throws Exception;
}
