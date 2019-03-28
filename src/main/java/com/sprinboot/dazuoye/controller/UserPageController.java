package com.sprinboot.dazuoye.controller;

import com.sprinboot.dazuoye.service.GameServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserPageController {
    @Resource
    private GameServices gameServices;

    @RequestMapping("/index")
    public String index(){
        return "user/index";
    }

    //    查询所有游戏并分页(跳转至游戏商城)
    @RequestMapping("/profile")
    public String profile(@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage, Model model) throws Exception {
        model.addAttribute("gameinfo", gameServices.findByPage(currentPage));
        return "profile";
    }

    //    跳转至游戏具体页面
    @RequestMapping("/game_info")
    public String game_info(){
        return "user/game_info";
    }

    //    跳转至论坛
    @RequestMapping("/about")
    public String about() {
        return "user/about";
    }

    //    跳转至详细论坛
    @RequestMapping("/community")
    public String community() {
        return "user/community";
    }
}