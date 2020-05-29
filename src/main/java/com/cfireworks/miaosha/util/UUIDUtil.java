package com.cfireworks.miaosha.util;

import java.util.UUID;

/**
 * @description: 生成cookie
 * @author: cfireworks
 * @create: 2020-05-13 16:05
 **/
public class UUIDUtil {
    public static String uuid(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
