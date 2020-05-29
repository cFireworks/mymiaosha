package com.cfireworks.miaosha.service;

import com.cfireworks.miaosha.dao.MiaoshaUserDao;
import com.cfireworks.miaosha.domain.MiaoshaUser;
import com.cfireworks.miaosha.exception.GlobalException;
import com.cfireworks.miaosha.redis.MiaoshaUserKey;
import com.cfireworks.miaosha.redis.RedisService;
import com.cfireworks.miaosha.result.CodeMsg;
import com.cfireworks.miaosha.util.MD5Util;
import com.cfireworks.miaosha.util.UUIDUtil;
import com.cfireworks.miaosha.vo.LoginVo;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 用户服务类
 * @author: cfireworks
 * @create: 2020-05-13 13:47
 **/
@Service
public class MiaoshaUserService {

    public static final String COOKI_NAME_TOKEN = "token";

    @Autowired
    MiaoshaUserDao miaoshaUserDao;

    @Autowired
    RedisService redisService;


    public CodeMsg login(HttpServletResponse response, LoginVo loginVo){
        if(loginVo == null) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        String mobile = loginVo.getMobile();
        String fromPass = loginVo.getPassword();

        // 判断手机是否存在
        MiaoshaUser user = getById(Long.parseLong(mobile));
        if(user == null){
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        // 验证密码
        String dbPass = user.getPassword();
        String saltDB = user.getSalt();
        String calcPass = MD5Util.formPassToDBPass(fromPass, saltDB);

        if(!calcPass.equals(dbPass)){
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }
        //生成Cookie
        String token = UUIDUtil.uuid();
        addCookie(response, token, user);

        return CodeMsg.SUCCESS;
    }
    private void addCookie(HttpServletResponse response, String token, MiaoshaUser user){
        redisService.set(MiaoshaUserKey.token, token, user);
        Cookie cookie = new Cookie(COOKI_NAME_TOKEN, token);
        cookie.setMaxAge(MiaoshaUserKey.token.getExpireSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
    }
    public MiaoshaUser getById(long id) {
        // 1. 取缓存
        MiaoshaUser user = redisService.get(MiaoshaUserKey.getById, ""+id, MiaoshaUser.class);
        if(user != null){
            return user;
        }
        // 2. 取数据库
        user = miaoshaUserDao.getById(id);
        if(user != null){
            redisService.set(MiaoshaUserKey.getById, ""+id, user);
        }
        return user;
    }

    public boolean updatePassword(String token, long id, String formPass) {
        //取user
        MiaoshaUser user = getById(id);
        if(user == null) {
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        //更新数据库
        MiaoshaUser toBeUpdate = new MiaoshaUser();
        toBeUpdate.setId(id);
        toBeUpdate.setPassword(MD5Util.formPassToDBPass(formPass, user.getSalt()));
        miaoshaUserDao.update(toBeUpdate);
        //处理缓存
        redisService.delete(MiaoshaUserKey.getById, ""+id);
        user.setPassword(toBeUpdate.getPassword());
        redisService.set(MiaoshaUserKey.token, token, user);
        return true;
    }

    public MiaoshaUser getByToken(HttpServletResponse response, String token) {
        if(StringUtils.isNullOrEmpty(token)){
            return null;
        }else{
            MiaoshaUser user = redisService.get(MiaoshaUserKey.token, token, MiaoshaUser.class);
            if(user != null)
                addCookie(response, token, user);
            return user;
        }
    }
}
