package com.sprinboot.dazuoye.controller;

import com.alibaba.fastjson.JSONObject;
import com.sprinboot.dazuoye.pojo.Essay;
import com.sprinboot.dazuoye.service.essayServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class essayController {
    @Resource
    private essayServices essayServices;


    //    查询文章（模糊查询）
    @RequestMapping(value = "/getEssay")
    @ResponseBody
    public String getEssay(@RequestParam(value = "title", required = false) String title, @RequestParam(value = "id", required = false) Integer id, ServletResponse res) throws Exception {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        JSONObject json = new JSONObject();
        List<Essay> user = essayServices.getEssay(title, id);
        if (user != null) {
            json.put("data", user);
            json.put("desc", "查询成功");
            json.put("status", "200");
        } else {
            json.put("status", "201");
            json.put("desc", "查询失败！");
            json.put("data", "");
        }
        return json.toJSONString();
    }


    //    添加文章
    @RequestMapping(value = "/insertEssay")
    @ResponseBody
    public String insertEssay(@RequestParam String title, @RequestParam String username, @RequestParam String name,
                              @RequestParam String date, @RequestParam String essayType, @RequestParam String content, @RequestParam String url,
                              @RequestParam String OTitle, ServletResponse res) throws Exception {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        JSONObject json = new JSONObject();
        if (essayServices.insertEssay(title, username, name, date, essayType, content, url, OTitle) > 0) {
            json.put("data", "");
            json.put("desc", "文章添加成功！");
            json.put("status", "200");
        } else {
            json.put("data", "");
            json.put("desc", "文章添加失败！");
            json.put("status", "201");
        }
        return json.toJSONString();
    }
}
