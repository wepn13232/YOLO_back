package com.sprinboot.dazuoye.controller;

import com.alibaba.fastjson.JSONObject;
import com.sprinboot.dazuoye.dao.CommentDao;
import com.sprinboot.dazuoye.pojo.*;
import com.sprinboot.dazuoye.service.*;
import com.sprinboot.dazuoye.service.serviceImpl.UserinfoServicesImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserPageController {
    @Resource
    private GameServices gameServices;
    @Resource
    private UserServices userServices;
    @Resource
    private ChargeServices chargeServices;
    @Resource
    private ShopCarServices shopCarServices;
    @Resource
    private CommentDao commentDao;
    @Resource
    private UserinfoServices userinfoServices;


    @RequestMapping("/index")
    public String index() {
        return "user/index";
    }


    //    跳转至用户信息界面
    @RequestMapping("/userinfo")
    public String userinfo(@RequestParam String username, Model model) throws Exception {
        int cashLef = chargeServices.checkCashLeft(username);
        model.addAttribute("cashLeft", cashLef);
//        查询已拥有的游戏
        List<Game> games = userinfoServices.getGameByUser(username);
//        System.out.println(games);
        model.addAttribute("userGameInfo", games);

        return "user/userinfo";
    }


    //    查询所有游戏并分页(跳转至游戏商城)
    @RequestMapping("/profile")
    public String profile(@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage, Model model, HttpServletRequest request) throws Exception {
        String username = ((User) request.getSession().getAttribute("usersession")).getUsername();
        model.addAttribute("gameinfo", gameServices.findByPage(currentPage, username));
        return "user/profile";
    }

    //    跳转至游戏具体页面
    @RequestMapping("/game_info")
    public String game_info(@RequestParam Integer id, Model model) throws Exception {
        List<Game> games = gameServices.selectGameById(id);
        List<Comment> comments = commentDao.getAllCommentById(id);
        for (Game game : games) {
            model.addAttribute("gameinfoByid", game);
        }
        model.addAttribute("comment", comments);

        return "user/game_info";
    }

    //  发表新的评论
    @RequestMapping(value = "/addComment")
    @ResponseBody
    public String addComment(String name, String comments, int id) throws Exception {
        JSONObject json = new JSONObject();

//        Integer flag = commentDao.selectGameStatus(name,id);
//        System.out.println("******************"+name+"*******"+comments+"*********"+id);
        Comment comment = new Comment();
        comment.setUsername(name);
        comment.setGame_id(id);
        comment.setComment(comments);
//        if (flag==1){
        if (commentDao.addComment(comment)) {
            json.put("msg", "success");
        } else {
            json.put("msg", "error1");   //添加失败
        }
//        }   else {
//            json.put("msg","error2");   //未购买游戏
//        }
        return json.toJSONString();
    }


    //    论坛首页查询所有游戏
    @RequestMapping("/about")
    public String about(Model model) throws Exception {
        Game game = new Game();
        List<Game> games = gameServices.getAllGame(game);
        model.addAttribute("gamesinfo", games);
        return "user/about";
    }


    //    跳转至详细论坛
    @RequestMapping("/community")
    public String community() {
        return "user/community";
    }

    //    跳转至充值页面
    @RequestMapping("/charge")
    public String charge(@RequestParam String username, Model model) throws Exception {
        int cash = chargeServices.checkCashLeft(username);
        model.addAttribute("cashleft", cash);
        return "user/charge";
    }


    //    跳转至购物车、订单界面
    @RequestMapping("/orderList")
    public String orderList(@RequestParam String username, Model model) throws Exception {
        List<ShopCar> shopCarList = shopCarServices.findShopCarByUserName(username);
        if (shopCarList != null) {
            model.addAttribute("shopCarList", shopCarList);
        }
        return "user/orderList";
    }


    //账户充值
    @RequestMapping("/userCharge")
    @ResponseBody
    public String userCharge(@RequestParam int cashCharge, @RequestParam String username) throws Exception {
        JSONObject jsonObject = new JSONObject();
        if (userServices.chargeMoney(cashCharge, username) >= 1) {
            jsonObject.put("charge", "success");
        } else {
            jsonObject.put("charge", "error");
        }
        return jsonObject.toJSONString();
    }




}
