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
    public String dologin(@RequestParam String username, @RequestParam String password, ServletResponse res) throws Exception {
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

    //    注册用户
    @RequestMapping(value = "/doRegister")
    @ResponseBody
    public String doregister(@RequestParam String username, @RequestParam String name, @RequestParam String password,
                             @RequestParam String sex, @RequestParam String email, @RequestParam String address,
                             ServletResponse res) throws Exception {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        JSONObject jsonObject = new JSONObject();
        if (userServices.addUser(username, name, password, sex, email, address) > 0) {
            jsonObject.put("status", "200");
            jsonObject.put("desc", "注册成功");
            jsonObject.put("data", "");
        } else {
            jsonObject.put("status", "201");
            jsonObject.put("desc", "注册失败,请填写必要参数");
            jsonObject.put("data", "");
        }
        return jsonObject.toJSONString();
    }


    //    查询具体用户接口
    @RequestMapping(value = "/getUserInfo")
    @ResponseBody
    public String getUserInfo(@RequestParam(value = "username", required = false) String username, ServletResponse res) throws Exception {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        JSONObject json = new JSONObject();
        List<User> user = userServices.selectSomeUser(username);
        if (user != null) {
            json.put("data", user);
            json.put("desc", "查询成功");
            json.put("status", "200");
        } else {
            json.put("status", "201");
            json.put("desc", "没有该用户");
            json.put("data", "");
        }
        return json.toJSONString();
    }


    //    申请直播编码接口
    @RequestMapping(value = "/insertAppId")
    @ResponseBody
    public String insertAppId(@RequestParam String appid, @RequestParam String username, ServletResponse res) throws Exception {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        JSONObject jsonObject = new JSONObject();
        if (userServices.addAppId(appid, username) > 0) {
            jsonObject.put("status", "200");
            jsonObject.put("desc", "申请编码成功");
            jsonObject.put("data", "");
        } else {
            jsonObject.put("status", "201");
            jsonObject.put("desc", "插入编码数据失败");
            jsonObject.put("data", "");
        }
        return jsonObject.toJSONString();
    }


    //    编辑（更新）用户信息
    @RequestMapping(value = "/editUserInfo")
    @ResponseBody
    public String editUserInfo(@RequestParam(value = "userSum", required = false) String userSum, @RequestParam(value = "address", required = false) String address,
                               @RequestParam(value = "email", required = false) String email, @RequestParam(value = "appid", required = false) String appid,
                               @RequestParam String username,ServletResponse res) throws Exception {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        JSONObject jsonObject = new JSONObject();
        if (userServices.changeUserInfo(userSum, address, email, appid,username) > 0) {
            jsonObject.put("status", "200");
            jsonObject.put("desc", "修改用户信息成功");
            jsonObject.put("data", "");
        } else {
            jsonObject.put("status", "201");
            jsonObject.put("desc", "修改失败");
            jsonObject.put("data", "");
        }
        return jsonObject.toJSONString();
    }

}
