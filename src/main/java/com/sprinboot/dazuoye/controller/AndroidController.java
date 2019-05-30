package com.sprinboot.dazuoye.controller;

import com.alibaba.fastjson.JSONObject;
import com.sprinboot.dazuoye.pojo.Game;
import com.sprinboot.dazuoye.pojo.ShopCar;
import com.sprinboot.dazuoye.pojo.User;
import com.sprinboot.dazuoye.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    @RequestMapping(value = "/alogin")
    @ResponseBody
    public String alogin(@RequestParam String username, @RequestParam String password, HttpServletRequest request) throws Exception {
        JSONObject json = new JSONObject();
        User user = userServices.getUser(username, password);
        if (user != null) {
            /*request.getSession().setAttribute("session",user);
            json.put("session",user);*/
            json.put("user", user);
            json.put("status", "success");
        }
        return json.toJSONString();
    }

    @RequestMapping(value = "/finduser")
    @ResponseBody
    public String finduser() throws Exception {
        JSONObject json = new JSONObject();
        User user = userServices.getUser("admin", "123");
        if (user != null) {
            /*request.getSession().setAttribute("session",user);
            json.put("session",user);*/
            json.put("user", user);

        }
        return json.toJSONString();
    }


    //查询所有游戏（用于商城页和论坛页）
    @RequestMapping("/allGames")
    @ResponseBody
    public String allGames() throws Exception {
        JSONObject jsonObject = new JSONObject();
        Game game = new Game();
        List<Game> games = gameServices.getAllGame(game);
        jsonObject.put("games", games);
        return jsonObject.toJSONString();
    }


    //    游戏详情信息页（查询指定游戏信息）
    @RequestMapping("/gameInfo")
    @ResponseBody
    public String gameInfo(@RequestParam Integer id) throws Exception {
        JSONObject jsonObject = new JSONObject();
        List<Game> games = gameServices.selectGameById(id);
        jsonObject.put("gameInfo", games);
        return jsonObject.toJSONString();
    }


    //    跳转至购物车、订单页
    @RequestMapping("/orderList")
    @ResponseBody
    public String orderList(@RequestParam String username) throws Exception {
        JSONObject jsonObject = new JSONObject();
        List<ShopCar> shopCars = shopCarServices.findShopCarByUserName(username);
        jsonObject.put("shopCarsList", shopCars);
//        System.out.println(shopCars);
        return jsonObject.toJSONString();
    }

}