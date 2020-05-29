package com.cfireworks.miaosha.result;

/**
 * @description: codemsg
 * @author: cfireworks
 * @create: 2020-04-04 13:10
 **/
public class CodeMsg {


    private int code;
    private String msg;

    // 通用异常
    public static CodeMsg SUCCESS = new CodeMsg(0, "success");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务端异常");
    public static CodeMsg REQUEST_ILLEGAL = new CodeMsg(500101, "请求非法");
    public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500102, "密码不能为空");
    public static CodeMsg MOBILE_EMPTY = new CodeMsg(500103, "手机号不能为空");
    public static CodeMsg MOBILE_ERROR = new CodeMsg(500104, "手机号格式错误");
    public static CodeMsg MOBILE_NOT_EXIST = new CodeMsg(500105, "用户不存在");
    public static CodeMsg PASSWORD_ERROR = new CodeMsg(500106, "用户密码错误");
    public static CodeMsg BIND_ERROR = new CodeMsg(500107, "参数校验异常：%s");
    public static CodeMsg ACCESS_LIMIT_REACHED= new CodeMsg(500108, "访问太频繁！");

    //登录模块 5002XX
    public static CodeMsg SESSION_ERROR = new CodeMsg(500210, "Session不存在或者已经失效");

    //订单模块 5004XX
    public static CodeMsg ORDER_NOT_EXIST = new CodeMsg(500400, "订单不存在");

    //秒杀模块 5005XX
    public static CodeMsg MIAO_SHA_OVER = new CodeMsg(500500, "商品已经秒杀完毕");
    public static CodeMsg REPEATE_MIAOSHA = new CodeMsg(500501, "不能重复秒杀");
    public static CodeMsg MIAOSHA_FAIL = new CodeMsg(500502, "秒杀失败");
    // 商品模块

    // ...
    private CodeMsg(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
    public int getCode(){
        return code;
    }
    public String getMsg(){
        return msg;
    }

    public CodeMsg fillArgs(Object... args) {
        int code = this.code;
        String message = String.format(this.msg, args);
        return new CodeMsg(code, message);
    }
}
