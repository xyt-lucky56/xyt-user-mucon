package com.xyt.usermucon.common;

public class BizException extends RuntimeException {
    private String code;
    private String msg;
    public BizException() {
        super();
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String code,String msg) {
        super(msg);
        this.code=code;
    }

    public BizException(String code,String msg, Throwable cause) {
        super(msg, cause);
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
