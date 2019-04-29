package com.news.enums;

import lombok.Getter;

/**
 * Created by dong_zhengdong on 2019/4/29.
 */
@Getter
public enum ResponseCode {

    SUCCESS(200, "success"),
    ERROR(500, "error");


    /**
     * 响应码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String message;


    ResponseCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
