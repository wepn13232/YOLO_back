package com.sprinboot.dazuoye.controller;

import com.alibaba.fastjson.JSONObject;
import com.sprinboot.dazuoye.pojo.User;
import com.sprinboot.dazuoye.service.UserServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Resource
    private UserServices userServices;


    //    登录操作
    @RequestMapping("/dologin")
    @ResponseBody
    public String dologin(@RequestParam String username, @RequestParam String password, Model model, ServletResponse res) throws Exception {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        User user = userServices.getUser(username, password);
        JSONObject json = new JSONObject();

        if (user != null) {
            json.put("data", user);
            json.put("desc", "登录成功");
            json.put("status", "200");

        } else {
            json.put("desc", "登录失败，账号密码错误");
            json.put("status", "201");
        }
        return json.toJSONString();
    }

//    //    注册用户
//    @RequestMapping(value = "/doregister")
//    @ResponseBody
//    public String doregister(String userName, String password) throws Exception {
//        JSONObject jsonObject = new JSONObject();
//        if (userServices.addUser(userName, password) > 0) {
//            jsonObject.put("useradd", "1");
//        } else {
//            jsonObject.put("useradd", "0");
//        }
//        return jsonObject.toJSONString();
//    }


}
