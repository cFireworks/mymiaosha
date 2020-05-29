package com.cfireworks.miaosha.controller;

import com.cfireworks.miaosha.domain.User;
import com.cfireworks.miaosha.rabbitmq.MQSender;
import com.cfireworks.miaosha.redis.RedisService;
import com.cfireworks.miaosha.redis.UserKey;
import com.cfireworks.miaosha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cfireworks.miaosha.result.*;

/**
 * @description: demo
 * @author: cfireworks
 * @create: 2020-04-04 12:33
 **/
@Controller
@RequestMapping("/hello")
public class DemoController {

    @Autowired
    UserService userService;

    @Autowired
    RedisService redisService;

    @Autowired
    MQSender sender;

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Hello World!";
    }

//    @RequestMapping("/mq/header")
//    @ResponseBody
//    public Result<String> mqHeader() {
//        String msg = "hello, cfireworks";
//        sender.sendHeader(msg);
//        return Result.success(msg);
//    }
//
//    @RequestMapping("/mq/fanout")
//    @ResponseBody
//    public Result<String> mqFanout() {
//        String msg = "hello, cfireworks";
//        sender.sendFanout(msg);
//        return Result.success(msg);
//    }
//
//    @RequestMapping("/mq/topic")
//    @ResponseBody
//    public Result<String> mqTopic() {
//        String msg = "hello, cfireworks";
//        sender.sendTopic(msg);
//        return Result.success(msg);
//    }
//
//    @RequestMapping("/mq")
//    @ResponseBody
//    public Result<String> mq() {
//        String msg = "hello, cfireworks";
//        sender.send(msg);
//        return Result.success(msg);
//    }

    @RequestMapping("/hello")
    @ResponseBody
    public Result<String> hello() {
        return Result.success("hello, cfireworks");
    }

    @RequestMapping("/helloError")
    @ResponseBody
    public Result<String> helloError(){
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model){
        model.addAttribute("name", "cfireworks");
        return "hello";
    }

    @RequestMapping("/db/get")
    @ResponseBody
    public Result<User> dbGet(){
        User user = userService.getById(1);
        return Result.success(user);
    }

    @RequestMapping("/db/tx")
    @ResponseBody
    public Result<Boolean> dbTx(){
        userService.tx();
        return Result.success(true);
    }

    @RequestMapping("/redis/get")
    @ResponseBody
    public Result<User> redisGet(){
        User user = redisService.get(UserKey.getById, ""+1, User.class);
        return Result.success(user);
    }

    @RequestMapping("/redis/set")
    @ResponseBody
    public Result<Boolean> redisSet(){
        User user = new User();
        user.setId(1);
        user.setName("1111");
        boolean ret = redisService.set(UserKey.getById, ""+1, user);
        return Result.success(ret);
    }
}
