package com.example.demo.exception;

import cn.hutool.core.text.CharSequenceUtil;

/**
 * @author jielum
 */
public class AlreadyExistException extends BaseException {

    public AlreadyExistException(String... message){
        super.message = message;
    }

    @Override
    public int getErrCode() {
        return PARAMS_EXCEPTION;
    }

    @Override
    public String getErrMsg() {
        return CharSequenceUtil.format("{}", message);
    }
}
