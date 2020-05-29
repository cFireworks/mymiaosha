package com.cfireworks.miaosha.redis;

/**
 * @description:
 * @author: cfireworks
 * @create: 2020-04-04 17:43
 **/
public class MiaoshaUserKey extends BaseKeyPrefix{

    public static final int TOKEN_EXPIRE = 3600*24*2;

    private MiaoshaUserKey(int expireSeconds, String prefix){
        super(expireSeconds, prefix);
    }

    public static MiaoshaUserKey token = new MiaoshaUserKey(TOKEN_EXPIRE, "tk");
    public static MiaoshaUserKey getById = new MiaoshaUserKey(0, "id");
    // public static MiaoshaUserKey getByName = new MiaoshaUserKey("name");

}
