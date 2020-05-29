package com.cfireworks.miaosha.redis;

import com.cfireworks.miaosha.domain.User;

/**
 * @description:
 * @author: cfireworks
 * @create: 2020-04-04 17:43
 **/
public class UserKey extends BaseKeyPrefix{


    private UserKey(String prefix){
        super(prefix);
    }

    public static UserKey getById = new UserKey("id");
    public static UserKey getByName = new UserKey("name");

}
