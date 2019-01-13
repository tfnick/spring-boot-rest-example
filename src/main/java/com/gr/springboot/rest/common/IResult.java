package com.gr.springboot.rest.common;

public class IResult {
    int code;
    String message;

    Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static IResult buildSucces(Object data){
        IResult result = new IResult();
        result.code = 200;
        result.message = "success";
        result.data = data;
        return result;
    }

    public static IResult buildFail(){
        IResult result = new IResult();
        result.code = 500;
        result.message = "fail";
        return result;
    }
}
