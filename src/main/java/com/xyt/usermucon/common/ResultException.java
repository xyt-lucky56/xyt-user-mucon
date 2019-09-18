package com.xyt.usermucon.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ResultException {
    private Logger logger = LoggerFactory.getLogger(ResultException.class);

    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${server.port}")
    private int port;
    @Autowired
    private KafkaTemplate kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    @ExceptionHandler({BizException.class})
    public Map<String,Object> dealBizException(Exception e){
        Map<String,Object> map=new HashMap<>();
        BizException be = (BizException) e;
        map.put("code", be.getCode());
        map.put("msg",be.getMessage());
        map.put("data",null);
        map.put("count",0);
        //sendMsg(be);
        return map;
    }

    private void sendMsg(BizException be) {
        //异常code
        String code = be.getCode();
        //异常msg
        String message = be.getMessage();
        logger.info(be.getCause()+"");
        //异常名称
       // String exceptionName = be.getCause().getClass().getName();
        StackTraceElement[] stackTrace = be.getStackTrace();
        //出现异常的类名
        String className = stackTrace[0].getClassName();
        //出现的异常的文件名称
        String fileName = stackTrace[0].getFileName();
        //出现异常所在行
        int lineNumber = stackTrace[0].getLineNumber();
        //出现异常的方法
        String methodName = stackTrace[0].getMethodName();
        Message msg = new Message();
        msg.setCode(code);
        msg.setMsg(message);
       // msg.setExceptionName(exceptionName);
        msg.setClassName(className);
        msg.setFileName(fileName);
        msg.setLineNumber(lineNumber);
        msg.setMethodName(methodName);
        msg.setApplicationName(applicationName);
        msg.setPort(port);
        msg.setCreateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        kafkaTemplate.send("exception",gson.toJson(msg));
    }
}
