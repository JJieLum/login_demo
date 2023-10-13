package com.example.demo.exception;

/**
 * @author jielum
 */
public abstract class BaseException extends RuntimeException{

    protected transient Object[] message;

    /**
     * 错误码
     * @return int
     */
    public abstract int getErrCode();

    /**
     * 错误信息
     * @return String
     */
    public abstract String getErrMsg();

    @Override
    public String getMessage() {
        return "错误码:" + getErrCode() + "; 错误信息:" + getErrMsg();
    }

    /* Param Error */
    /**
     * 参数异常
     */
    public static final int  PARAMS_EXCEPTION = 10000;


}