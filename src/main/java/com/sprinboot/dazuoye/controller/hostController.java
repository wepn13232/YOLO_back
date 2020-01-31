package com.sprinboot.dazuoye.controller;

import com.alibaba.fastjson.JSONObject;
import com.sprinboot.dazuoye.pojo.Host;
import com.sprinboot.dazuoye.service.hostServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

@Controller
public class hostController {
    @Resource
    private hostServices hostServices;

    //    开播主播信息添加
    @RequestMapping(value = "/insertHost")
    @ResponseBody
    public String insertHost(@RequestParam String username, @RequestParam String name, @RequestParam String appid,
                             @RequestParam String title, @RequestParam String roomSum, ServletResponse res) throws Exception {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        JSONObject json = new JSONObject();
        if (hostServices.insertHost(username, name, appid, title, roomSum) > 0) {
            json.put("data", "");
            json.put("desc", "用户开播成功！");
            json.put("status", "200");
        } else {
            json.put("data", "");
            json.put("desc", "用户开播失败！");
            json.put("status", "201");
        }
        return json.toJSONString();
    }


    //    获取主播信息
    @RequestMapping(value = "/getHostInfo")
    @ResponseBody
    public String getHostInfo(@RequestParam String username, ServletResponse res) throws Exception {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        JSONObject json = new JSONObject();
        Host host = new Host();
        host = hostServices.getHostInfo(username);

        json.put("data", host);
        json.put("desc", "获取用户信息成功！");
        json.put("status", "200");

        return json.toJSONString();
    }

}
