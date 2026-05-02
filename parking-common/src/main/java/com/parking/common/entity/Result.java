package com.parking.common.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 通用返回结果类
 *
 * @param <T> 数据类型
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 成功状态码
     */
    public static final int SUCCESS_CODE = 200;

    /**
     * 失败状态码
     */
    public static final int ERROR_CODE = 500;

    /**
     * 未授权状态码
     */
    public static final int UNAUTHORIZED_CODE = 401;

    /**
     * 禁止访问状态码
     */
    public static final int FORBIDDEN_CODE = 403;

    /**
     * 资源未找到状态码
     */
    public static final int NOT_FOUND_CODE = 404;

    /**
     * 参数错误状态码
     */
    public static final int PARAM_ERROR_CODE = 400;

    /**
     * 状态码
     */
    private int code;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 响应时间戳
     */
    private long timestamp;

    /**
     * 成功返回
     *
     * @param data 返回数据
     * @param <T>  数据类型
     * @return Result
     */
    public static <T> Result<T> success(T data) {
        return Result.<T>builder()
                .code(SUCCESS_CODE)
                .message("操作成功")
                .data(data)
                .timestamp(System.currentTimeMillis())
                .build();
    }

    /**
     * 成功返回（带自定义消息）
     *
     * @param data    返回数据
     * @param message 提示信息
     * @param <T>     数据类型
     * @return Result
     */
    public static <T> Result<T> success(T data, String message) {
        return Result.<T>builder()
                .code(SUCCESS_CODE)
                .message(message)
                .data(data)
                .timestamp(System.currentTimeMillis())
                .build();
    }

    /**
     * 成功返回（无数据）
     *
     * @return Result
     */
    public static <T> Result<T> success() {
        return Result.<T>builder()
                .code(SUCCESS_CODE)
                .message("操作成功")
                .data(null)
                .timestamp(System.currentTimeMillis())
                .build();
    }

    /**
     * 失败返回
     *
     * @param message 错误信息
     * @param <T>     数据类型
     * @return Result
     */
    public static <T> Result<T> error(String message) {
        return Result.<T>builder()
                .code(ERROR_CODE)
                .message(message)
                .data(null)
                .timestamp(System.currentTimeMillis())
                .build();
    }

    /**
     * 失败返回（带状态码）
     *
     * @param code    状态码
     * @param message 错误信息
     * @param <T>     数据类型
     * @return Result
     */
    public static <T> Result<T> error(int code, String message) {
        return Result.<T>builder()
                .code(code)
                .message(message)
                .data(null)
                .timestamp(System.currentTimeMillis())
                .build();
    }

    /**
     * 未授权返回
     *
     * @param message 错误信息
     * @param <T>     数据类型
     * @return Result
     */
    public static <T> Result<T> unauthorized(String message) {
        return Result.<T>builder()
                .code(UNAUTHORIZED_CODE)
                .message(message)
                .data(null)
                .timestamp(System.currentTimeMillis())
                .build();
    }

    /**
     * 禁止访问返回
     *
     * @param message 错误信息
     * @param <T>     数据类型
     * @return Result
     */
    public static <T> Result<T> forbidden(String message) {
        return Result.<T>builder()
                .code(FORBIDDEN_CODE)
                .message(message)
                .data(null)
                .timestamp(System.currentTimeMillis())
                .build();
    }

    /**
     * 资源未找到返回
     *
     * @param message 错误信息
     * @param <T>     数据类型
     * @return Result
     */
    public static <T> Result<T> notFound(String message) {
        return Result.<T>builder()
                .code(NOT_FOUND_CODE)
                .message(message)
                .data(null)
                .timestamp(System.currentTimeMillis())
                .build();
    }

    /**
     * 参数错误返回
     *
     * @param message 错误信息
     * @param <T>     数据类型
     * @return Result
     */
    public static <T> Result<T> paramError(String message) {
        return Result.<T>builder()
                .code(PARAM_ERROR_CODE)
                .message(message)
                .data(null)
                .timestamp(System.currentTimeMillis())
                .build();
    }

    /**
     * 判断是否成功
     *
     * @return 是否成功
     */
    public boolean isSuccess() {
        return this.code == SUCCESS_CODE;
    }
}