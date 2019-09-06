package com.xyt.usermucon.common;

public class BizException extends RuntimeException {
    private String code;
    private String msg;
    public BizException() {
        super();
    }

    public BizException(String code,String message) {
        super(message);
        this.code=code;
    }

    public BizException(String code,String message, Throwable cause) {
        super(message, cause);
        this.code=code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
