package com.sprinboot.dazuoye.controller;

import com.alibaba.fastjson.JSONObject;
import com.sprinboot.dazuoye.pojo.Sub;
import com.sprinboot.dazuoye.service.subServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

@Controller
public class subController {
    @Resource
    subServices subServices;

    //    点赞
    @RequestMapping(value = "/sub")
    @ResponseBody
    public String sub(@RequestParam String subUser, @RequestParam Integer picId,
                      ServletResponse res) throws Exception {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        JSONObject jsonObject = new JSONObject();
        if (subServices.insertSub(subUser, picId) > 0) {
            jsonObject.put("status", "200");
            jsonObject.put("desc", "点赞成功");
            jsonObject.put("data", "");
        } else {
            jsonObject.put("status", "201");
            jsonObject.put("desc", "点赞失败，未能插入数据");
            jsonObject.put("data", "");
        }
        return jsonObject.toJSONString();
    }

    //    获取用户是否点赞
    @RequestMapping(value = "/subOrNot")
    @ResponseBody
    public String subOrNot(@RequestParam String subUser, @RequestParam Integer picId,
                           ServletResponse res) throws Exception {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        JSONObject jsonObject = new JSONObject();
        Sub sub = subServices.subOrNot(subUser, picId);
        if (sub != null) {
            jsonObject.put("status", "200");
            jsonObject.put("desc", "用户已点赞");
            jsonObject.put("data", "");
        } else {
            jsonObject.put("status", "201");
            jsonObject.put("desc", "用户未点赞");
            jsonObject.put("data", "");
        }
        return jsonObject.toJSONString();
    }


    //    取消点赞
    @RequestMapping(value = "/cancelSub")
    @ResponseBody
    public String cancelSub(@RequestParam Integer picId, @RequestParam String subUser,
                            ServletResponse res) throws Exception {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        JSONObject jsonObject = new JSONObject();
        if (subServices.cancelSub(picId, subUser) > 0) {
            jsonObject.put("status", "200");
            jsonObject.put("desc", "用户取消点赞");
            jsonObject.put("data", "");
        } else {
            jsonObject.put("status", "201");
            jsonObject.put("desc", "用户取消点赞失败");
            jsonObject.put("data", "");
        }
        return jsonObject.toJSONString();
    }

    //    获取点赞的人数
    @RequestMapping(value = "/getSubCount")
    @ResponseBody
    public String getSubCount(@RequestParam Integer picId,
                              ServletResponse res) throws Exception {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        JSONObject jsonObject = new JSONObject();
        Sub sub = subServices.getSubCount(picId);
        jsonObject.put("status", "200");
        jsonObject.put("desc", "获取点赞数成功");
        jsonObject.put("data", sub);

        return jsonObject.toJSONString();
    }

}
