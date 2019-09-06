package com.xyt.usermucon.common;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ResultException {

    @ExceptionHandler({BizException.class})
    public Map<String,Object> dealBizException(Exception e){
        Map<String,Object> map=new HashMap<>();
        BizException be = (BizException) e;
        map.put("code", be.getCode());
        map.put("msg",be.getMessage());
        return map;
    }
}
