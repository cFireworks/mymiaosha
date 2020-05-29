package com.cfireworks.miaosha.controller;

import com.cfireworks.miaosha.domain.User;
import com.cfireworks.miaosha.redis.RedisService;
import com.cfireworks.miaosha.redis.UserKey;
import com.cfireworks.miaosha.result.CodeMsg;
import com.cfireworks.miaosha.result.Result;
import com.cfireworks.miaosha.service.MiaoshaUserService;
import com.cfireworks.miaosha.service.UserService;
import com.cfireworks.miaosha.util.ValidatorUtil;
import com.cfireworks.miaosha.vo.LoginVo;
import com.mysql.cj.util.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @description: demo
 * @author: cfireworks
 * @create: 2020-04-04 12:33
 **/
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    MiaoshaUserService userService;

    @Autowired
    RedisService redisService;

    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/to_login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/do_login")
    @ResponseBody
    public Result<Boolean> doLogin(HttpServletResponse response, @Valid LoginVo loginvo){
        log.info(loginvo.toString());
        String passInput = loginvo.getPassword();
        String mobile = loginvo.getMobile();
        // 登录
        CodeMsg cm = userService.login(response, loginvo);
        if(cm.getCode() == 0){
            return Result.success(true);
        }else{
            return Result.error(cm);
        }
    }
}
