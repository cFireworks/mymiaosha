package com.cfireworks.miaosha.util;

import com.alibaba.druid.sql.ast.statement.SQLForeignKeyImpl;
import com.mysql.cj.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description: 校验手机号码
 * @author: cfireworks
 * @create: 2020-05-13 13:38
 **/
public class ValidatorUtil {
    private static  final Pattern mobile_pattern = Pattern.compile("1\\d{10}");
    public static boolean isMobile(String src){
        if(StringUtils.isNullOrEmpty(src)){
            return false;
        }
        Matcher m = mobile_pattern.matcher(src);
        return m.matches();
    }
    public static void main(String[] args){
        System.out.println(ValidatorUtil.isMobile("15852931528"));
        System.out.println(ValidatorUtil.isMobile("5852931528"));
    }
}
