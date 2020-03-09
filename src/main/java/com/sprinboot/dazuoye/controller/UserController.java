package com.sprinboot.dazuoye.controller;

import com.alibaba.fastjson.JSONObject;
import com.sprinboot.dazuoye.pojo.Host;
import com.sprinboot.dazuoye.pojo.User;
import com.sprinboot.dazuoye.pojo.addressInfo;
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
import java.util.Base64;
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
        final Base64.Decoder decoder = Base64.getDecoder();
        //解码
        System.out.println(new String(decoder.decode(password), "UTF-8"));
        User user = userServices.getUser(username, new String(decoder.decode(password), "UTF-8"));
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


    //    根据昵称查询具体用户接口
    @RequestMapping(value = "/getUserInfoByName")
    @ResponseBody
    public String getUserInfoByName(@RequestParam String name, ServletResponse res) throws Exception {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        JSONObject json = new JSONObject();
        User user = userServices.selectUserByName(name);
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
                               @RequestParam(value = "email", required = false) String email, @RequestParam(value = "appid", required = false) String appid, @RequestParam(value = "picUrl", required = false) String picUrl,
                               @RequestParam String username, ServletResponse res) throws Exception {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        JSONObject jsonObject = new JSONObject();
        if (userServices.changeUserInfo(userSum, address, email, appid, username, picUrl) > 0) {
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


    //    查询appid
    @RequestMapping(value = "/getAppid")
    @ResponseBody
    public String getAppid(@RequestParam String username, ServletResponse res) throws Exception {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        JSONObject json = new JSONObject();
        User user = userServices.selectAppid(username);
        if (user != null) {
            json.put("data", user);
            json.put("desc", "查询成功");
            json.put("status", "200");
        } else {
            json.put("status", "201");
            json.put("desc", "用户无appid数据");
            json.put("data", "");
        }
        return json.toJSONString();
    }


    //    admin获取主播信息
    @RequestMapping(value = "/adminGetHost")
    @ResponseBody
    public String adminGetHost(ServletResponse res) throws Exception {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        JSONObject json = new JSONObject();
        List<Host> hosts = userServices.adminGetHost();
        if (hosts != null) {
            json.put("data", hosts);
            json.put("desc", "查询成功");
            json.put("status", "200");
        } else {
            json.put("status", "201");
            json.put("desc", "暂无数据");
            json.put("data", "");
        }
        return json.toJSONString();
    }


    //    封禁直播
    @RequestMapping(value = "/banLive")
    @ResponseBody
    public String banLive(@RequestParam String liveStatus, @RequestParam String username, ServletResponse res) throws Exception {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        JSONObject json = new JSONObject();

        if (userServices.banLive(liveStatus, username) > 0) {
            json.put("data", "");
            json.put("desc", "修改直播状态成功");
            json.put("status", "200");
        } else {
            json.put("status", "201");
            json.put("desc", "修改直播状态失败");
            json.put("data", "");
        }
        return json.toJSONString();
    }


    //    获取男女人数
    @RequestMapping(value = "/getNumOfSex")
    @ResponseBody
    public String getNumOfSex(ServletResponse res) throws Exception {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        JSONObject json = new JSONObject();
        User user = userServices.getNumOfUserSex();
        if (user != null) {
            json.put("data", user);
            json.put("desc", "获取男女人数比例成功");
            json.put("status", "200");
        } else {
            json.put("status", "201");
            json.put("desc", "无数据");
            json.put("data", "");
        }
        return json.toJSONString();
    }

    //    获取地区人数
    @RequestMapping(value = "/getAddressNum")
    @ResponseBody
    public String getAddressNum(ServletResponse res) throws Exception {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        JSONObject json = new JSONObject();
        List<addressInfo> user = userServices.getAddressNum();
        if (user != null) {
            json.put("data", user);
            json.put("desc", "获取地址比例成功");
            json.put("status", "200");
        } else {
            json.put("status", "201");
            json.put("desc", "无数据");
            json.put("data", "");
        }
        return json.toJSONString();
    }


    //更新用户分数
    @RequestMapping(value = "/updateUserScore")
    @ResponseBody
    public String updateUserScore(@RequestParam String userScore, @RequestParam String username, ServletResponse res) throws Exception {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        JSONObject json = new JSONObject();
        if (userServices.updateUserScore(userScore, username) > 0) {
            json.put("data", "");
            json.put("desc", "更新用户分数成功");
            json.put("status", "200");
        } else {
            json.put("status", "201");
            json.put("desc", "更新用户数据失败");
            json.put("data", "");
        }
        return json.toJSONString();
    }


    //根据用户分数获取数据
    @RequestMapping(value = "/getUserByScore")
    @ResponseBody
    public String getUserByScore(ServletResponse res) throws Exception {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        JSONObject json = new JSONObject();
        List<User> user = userServices.getUserByScore();
        if (user != null) {
            json.put("data", user);
            json.put("desc", "用户数据获取成功");
            json.put("status", "200");
        } else {
            json.put("status", "201");
            json.put("desc", "无数据 null");
            json.put("data", "");
        }
        return json.toJSONString();
    }


    //admin模糊查询用户
    @RequestMapping(value = "/getHostFuzzy")
    @ResponseBody
    public String getHostFuzzy(@RequestParam String name, ServletResponse res) throws Exception {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        JSONObject json = new JSONObject();
        List<Host> hosts = userServices.adminGetHostByFuzzy(name);
        if (hosts != null) {
            json.put("data", hosts);
            json.put("desc", "用户数据获取成功");
            json.put("status", "200");
        } else {
            json.put("status", "201");
            json.put("desc", "无数据 null");
            json.put("data", "");
        }
        return json.toJSONString();
    }


    //重置前确认用户信息
    @RequestMapping(value = "/userConfirm")
    @ResponseBody
    public String userConfirm(@RequestParam String username, @RequestParam String name, @RequestParam String email,
                              @RequestParam Integer questionT, @RequestParam String questionC, ServletResponse res) throws Exception {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        JSONObject json = new JSONObject();
        User user = userServices.userConfirm(username, name, email, questionT, questionC);
        if (user != null) {
            json.put("data", "");
            json.put("desc", "用户验证成功");
            json.put("status", "200");
        } else {
            json.put("status", "201");
            json.put("desc", "无数据 null，验证失败");
            json.put("data", "");
        }
        return json.toJSONString();
    }


    //重置密码
    @RequestMapping(value = "/resetPassword")
    @ResponseBody
    public String resetPassword(@RequestParam String password, String username,ServletResponse res) throws Exception {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        JSONObject json = new JSONObject();
        if (userServices.resetPassword(password,username) > 0) {
            json.put("data", "");
            json.put("desc", "修改密码成功");
            json.put("status", "200");
        } else {
            json.put("status", "201");
            json.put("desc", "修改密码失败");
            json.put("data", "");
        }
        return json.toJSONString();
    }

}

