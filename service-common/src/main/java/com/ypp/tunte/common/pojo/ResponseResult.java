package com.ypp.tunte.common.pojo;

import java.io.Serializable;

/**
 * <p>功能描述在这</p>
 *
 * @author pingpingyan
 * @date 2018/9/7 0007
 */
public class ResponseResult<T> implements Serializable {
    private final static  int SUCCESS_CODE=200;
    private final static  int FAIL_CODE=500;
    private final static  String  SUCCESS_DEFAULT_MESSAGE="请求成功";
    private final static  String  FAIL_DEFAULT_MESSAGE="请求错误";


    public ResponseResult(){}

    public ResponseResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private int code;
    private String message;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static ResponseResult success(){
        return new ResponseResult(SUCCESS_CODE,SUCCESS_DEFAULT_MESSAGE,null);
    }
    public static ResponseResult success(Object data){
        return new ResponseResult(SUCCESS_CODE,SUCCESS_DEFAULT_MESSAGE,data);
    }

    public static ResponseResult error(){
        return new ResponseResult(FAIL_CODE,FAIL_DEFAULT_MESSAGE,null);
    }

    public static ResponseResult error(String message){
        return new ResponseResult(FAIL_CODE,message,null);
    }

    public static ResponseResult error(String message,Object data){
        return new ResponseResult(FAIL_CODE,message,data);
    }

    public static ResponseResult error(Object data){
        return new ResponseResult(FAIL_CODE,FAIL_DEFAULT_MESSAGE,data);
    }
}
