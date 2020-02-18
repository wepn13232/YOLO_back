package com.sprinboot.dazuoye.controller;

import com.alibaba.fastjson.JSONObject;
import com.sprinboot.dazuoye.pojo.EssayComment;
import com.sprinboot.dazuoye.service.essayCommentServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class essayCommentControler {
    @Resource
    essayCommentServices essayCommentServices;

    //    评论
    @RequestMapping(value = "/insertComment")
    @ResponseBody
    public String insertComment(@RequestParam String username, @RequestParam String name,
                                @RequestParam String comment, @RequestParam String date,
                                @RequestParam Integer essayId, ServletResponse res) throws Exception {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        JSONObject json = new JSONObject();
        if (essayCommentServices.insertComment(username, name, comment, date, essayId) > 0) {
            json.put("data", "");
            json.put("desc", "评论成功！");
            json.put("status", "200");
        } else {
            json.put("data", "");
            json.put("desc", "评论失败！");
            json.put("status", "201");
        }
        return json.toJSONString();
    }

    //    查看评论
    @RequestMapping(value = "/getComment")
    @ResponseBody
    public String getComment(@RequestParam Integer essayId, ServletResponse res) throws Exception {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        JSONObject json = new JSONObject();
        List<EssayComment> essayComments = essayCommentServices.getComment(essayId);
        if (essayComments != null) {
            json.put("data", essayComments);
            json.put("desc", "获取评论成功！");
            json.put("status", "200");
        } else {
            json.put("data", "");
            json.put("desc", "无数据！有null");
            json.put("status", "201");
        }
        return json.toJSONString();
    }

}
