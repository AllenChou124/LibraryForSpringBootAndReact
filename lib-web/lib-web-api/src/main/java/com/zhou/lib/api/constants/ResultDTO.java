package com.zhou.lib.api.constants;

import lombok.Data;

/**
 * 基本返回数据结构
 * @author 12418
 */
@Data
public class ResultDTO {
    private String system;

    private Integer code;

    private String msg;

    private Object date;

    public ResultDTO(int code, String msg) {
        this.system = "lib";
        this.code = code;
        this.msg = msg;
    }


    public ResultDTO(int code, String msg, Object date) {
        this.system = "lib";
        this.code = code;
        this.msg = msg;
        this.date = date;
    }
}
