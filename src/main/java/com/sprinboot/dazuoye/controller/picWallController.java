package com.sprinboot.dazuoye.controller;

import com.alibaba.fastjson.JSONObject;
import com.sprinboot.dazuoye.pojo.PicWall;
import com.sprinboot.dazuoye.service.picWallServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class picWallController {
    @Resource
    private picWallServices picWallServices;

    //    获取照片墙所有信息
    @RequestMapping(value = "/getPicShows")
    @ResponseBody
    public String getPicShows(ServletResponse res) throws Exception {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        JSONObject json = new JSONObject();
        List<PicWall> picWalls = picWallServices.getAllPicShows();
        if (picWalls != null) {
            json.put("data", picWalls);
            json.put("desc", "获取照片墙信息成功！");
            json.put("status", "200");
        } else {
            json.put("data", picWalls);
            json.put("desc", "无照片墙数据");
            json.put("status", "201");
        }
        return json.toJSONString();
    }


    //    添加照片
    @RequestMapping(value = "/insertPic")
    @ResponseBody
    public String insertPic(@RequestParam String src,@RequestParam String content,@RequestParam String username,@RequestParam String name, ServletResponse res) throws Exception {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        JSONObject json = new JSONObject();
        if (picWallServices.insertPic(src,content,username,name)>0) {
            json.put("data", "");
            json.put("desc", "照片添加成功！");
            json.put("status", "200");
        } else {
            json.put("data", "");
            json.put("desc", "照片添加失败！");
            json.put("status", "201");
        }
        return json.toJSONString();
    }
}
