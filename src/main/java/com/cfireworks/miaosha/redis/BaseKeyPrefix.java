package com.cfireworks.miaosha.redis;

import com.fasterxml.jackson.databind.ser.Serializers;

/**
 * @description:
 * @author: cfireworks
 * @create: 2020-04-04 17:33
 **/
public abstract class BaseKeyPrefix implements KeyPrefix {

    private int expireSeconds;

    private String prefix;

    public BaseKeyPrefix(String prefix){
        this(0, prefix);
    }

    public BaseKeyPrefix(int expireSeconds, String prefix){
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }

    public int getExpireSeconds(){
        return expireSeconds;
    }

    public String getPrefix(){
        String className = getClass().getSimpleName();
        return className + ":" + prefix;
    }
}
