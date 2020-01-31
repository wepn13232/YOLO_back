package com.sprinboot.dazuoye.controller;

import com.alibaba.fastjson.JSONObject;
import com.sprinboot.dazuoye.pojo.Score;
import com.sprinboot.dazuoye.service.scoreServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class scoreController {
    @Resource
    private scoreServices scoreServices;

    //    用户等级打分
    @RequestMapping(value = "/setScore")
    @ResponseBody
    public String setScore(@RequestParam String username, @RequestParam String score, @RequestParam String setedUser, @RequestParam Integer essayID, ServletResponse res) throws Exception {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        JSONObject json = new JSONObject();
        if (scoreServices.insertScore(username, score, setedUser, essayID) > 0) {
            json.put("data", "");
            json.put("desc", "用户等级打分成功！");
            json.put("status", "200");
        } else {
            json.put("data", "");
            json.put("desc", "用户等级打分失败！");
            json.put("status", "201");
        }
        return json.toJSONString();
    }


    //    获取用户评分等级
    @RequestMapping(value = "/getScore")
    @ResponseBody
    public String getScore(@RequestParam String username, ServletResponse res) throws Exception {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        JSONObject json = new JSONObject();
        List<Score> scores = new ArrayList<>();
        scores = scoreServices.getScore(username);
        if (scores != null) {
            json.put("data", scores);
            json.put("desc", "获取用户评分成功！");
            json.put("status", "200");
        } else {
            json.put("data", "");
            json.put("desc", "用户无评分！");
            json.put("status", "201");
        }
        return json.toJSONString();
    }


    //    获取用户是否评分
    @RequestMapping(value = "/setScoreOrNot")
    @ResponseBody
    public String setScoreOrNot(@RequestParam String setedUser, @RequestParam Integer essayID, ServletResponse res) throws Exception {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        JSONObject json = new JSONObject();
        Score score = new Score();
        score = scoreServices.setScoreOrNot(setedUser, essayID);
        if (score != null) {
            json.put("data", score);
            json.put("desc", "用户已打分！");
            json.put("status", "200");
        } else {
            json.put("data", "");
            json.put("desc", "用户暂无打分");
            json.put("status", "201");
        }
        return json.toJSONString();
    }
}
