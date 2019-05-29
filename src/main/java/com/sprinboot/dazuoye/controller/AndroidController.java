package com.sprinboot.dazuoye.controller;

import com.alibaba.fastjson.JSONObject;
import com.sprinboot.dazuoye.pojo.User;
import com.sprinboot.dazuoye.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Cedric on 2019/5/27 22:31
 * @filename AndroidController
 * @description
 */
@Controller
public class AndroidController {
    @Resource
    private GameServices gameServices;
    @Resource
    private UserServices userServices;
    @Resource
    private ChargeServices chargeServices;
    @Resource
    private ShopCarServices shopCarServices;
    @Resource
    private CommentServices commentServices;
    @Resource
    private UserinfoServices userinfoServices;
    @Resource
    private ForumServices forumServices;

    //登录功能
    @RequestMapping(value = "/alogin",method = RequestMethod.POST)
    @ResponseBody
    public  String alogin(@RequestParam String username, @RequestParam String password, HttpServletRequest request)throws Exception{
        JSONObject json = new JSONObject();
        User user = userServices.getUser(username,password);
        if(user!=null){
            /*request.getSession().setAttribute("session",user);
            json.put("session",user);*/
            json.put("user",user);
            json.put("status","success");
        }
        return json.toJSONString();
    }

    @RequestMapping(value = "/finduser")
    @ResponseBody
    public  String finduser()throws Exception{
        JSONObject json = new JSONObject();
        User user = userServices.getUser("admin","123");
        if(user!=null){
            /*request.getSession().setAttribute("session",user);
            json.put("session",user);*/
            json.put("user",user);

        }
        return json.toJSONString();
    }


}