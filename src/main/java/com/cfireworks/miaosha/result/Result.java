package com.cfireworks.miaosha.result;

/**
 * @description: result
 * @author: cfireworks
 * @create: 2020-04-04 12:57
 **/
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    /**
     * 成功时候调用
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data){
        return new Result<T>(data);
    }

    /**
     * 失败时调用
     * @param cm
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(CodeMsg cm){
        return new Result<T>(cm);
    }

    private Result(T data){
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }
    private Result(CodeMsg cm){
        if(cm == null) return;
        this.code = cm.getCode();
        this.msg = cm.getMsg();
    }
    public int getCode(){
        return code;
    }
    public String getMsg(){
        return msg;
    }
    public T getData(){
        return data;
    }
}
