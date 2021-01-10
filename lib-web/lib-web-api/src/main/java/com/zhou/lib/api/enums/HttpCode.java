package com.zhou.lib.api.enums;

public enum HttpCode {
    /**
     * 成功具有数据
     */
    SUCCESS(1,"成功"),

    /**
     * 成功但无数据
     */
    FAIL(-1,"失败"),

    /**
     * 异常
     */
    EXCEPTION(500,"系统异常");

    private int code;

    private String msg;

    HttpCode(int code,String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }
}
