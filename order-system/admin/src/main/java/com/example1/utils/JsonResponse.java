package com.example1.utils;

import java.io.Serializable;

public class JsonResponse<R> implements Serializable {
    private static final long serialVersionUID = 7574078101944305355L;

    private int code;
    private String msg;
    private R data;

    public JsonResponse() {
    }

    public static <R> JsonResponse<R> success(R data) {
        JsonResponse<R> response = new JsonResponse();
        response.code = 1;
        response.data = data;
        response.msg = "success";
        return response;
    }

    public static <R> JsonResponse<R> success(R data, String msg) {
        JsonResponse<R> response = new JsonResponse();
        response.data = data;
        response.code = 1;
        response.msg = msg;
        return response;
    }

    public static <R> JsonResponse<R> msg(int code, String msg) {
        JsonResponse<R> response = new JsonResponse();
        response.code = code;
        response.msg = msg;
        return response;
    }

    public static <R> JsonResponse<R> failure(String msg) {
        return msg(-1, msg);
    }

    //getter and setter

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public R getData() {
        return data;
    }

    public JsonResponse<R> setCode(int code) {
        this.code = code;
        return this;
    }

    public JsonResponse<R> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public JsonResponse<R> setData(R data) {
        this.data = data;
        return this;
    }
}

