package com.sprinboot.dazuoye.controller;

import com.alibaba.fastjson.JSONObject;
import com.sprinboot.dazuoye.pojo.Space;
import com.sprinboot.dazuoye.service.spaceServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class spaceController {

    @Resource
    private spaceServices spaceServices;


    //    查询空间动态信息
    @RequestMapping(value = "/getSpaceInfo")
    @ResponseBody
    public String getSpaceInfo(@RequestParam String username, ServletResponse res) throws Exception {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        JSONObject json = new JSONObject();
        List<Space> space = spaceServices.getSpaceInfo(username);
        if (space != null) {
            json.put("data", space);
            json.put("desc", "查询空间动态信息成功！");
            json.put("status", "200");
        } else {
            json.put("data", space);
            json.put("desc", "无空间信息可查");
            json.put("status", "201");
        }
        return json.toJSONString();
    }


    //    插入空间动态信息
    @RequestMapping(value = "/insertSpaceInfo")
    @ResponseBody
    public String insertSpaceInfo(@RequestParam String username, @RequestParam String name, @RequestParam String date, @RequestParam String content,
                                  ServletResponse res) throws Exception {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        JSONObject json = new JSONObject();
        if (spaceServices.insertSpaceInfo(username, name, date, content) > 0) {
            json.put("data", "");
            json.put("desc", "添加空间动态成功！");
            json.put("status", "200");
        } else {
            json.put("data", "");
            json.put("desc", "添加空间动态失败！");
            json.put("status", "201");
        }
        return json.toJSONString();
    }
}
