package com.example.demo.entity.rest;

import com.alibaba.fastjson.JSON;
import lombok.*;

/**
 * @author jielum
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestResult<T> {
    private int errcode;

    private String errmsg;

    private T data;

    @Getter
    @AllArgsConstructor
    public enum CodeEnum {
        // 成功
        SUCCESS(0, "ok"),
        // 永久性转移重定向
        PERMANENTLY(302, "永久性转移重定向"),
        // 鉴权问题
        UNAUTHORIZED(401, "未鉴权或鉴权失败"),
        // 无资源访问权限
        FORBIDDEN(403, "无资源访问权限"),
        // 无法找到资源
        NOT_FOUND(404, "无法找到资源"),
        // 服务器内部错误
        ERROR(500, "error");

        private final int value;
        private final String description;
    }

    public static <T> RestResult<T> success() {
        return restResult(CodeEnum.SUCCESS.value, CodeEnum.SUCCESS.description, null);
    }

    public static <T> RestResult<T> success(T data) {
        return restResult(CodeEnum.SUCCESS.value, CodeEnum.SUCCESS.description, data);
    }

    public static <T> RestResult<T> error(String msg) {
        return restResult(CodeEnum.ERROR.value, msg, null);
    }

    public static <T> RestResult<T> error(int code, String msg, T data) {
        return restResult(code, msg, data);
    }

    public static <T> RestResult<T> error(int code, String msg) {
        return restResult(code, msg, null);
    }


    private static <T> RestResult<T> restResult(int code, String msg, T data) {
        return RestResult.<T>builder()
                .errcode(code)
                .errmsg(msg)
                .data(data)
                .build();
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}