package com.xyt.usermucon.common;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable{
    //异常code
	private String code;
	//异常消息
	private String msg;
	//异常名称
	private String exceptionName;
	//类名
	private String className;
	//文件名称
	private String fileName;
	//所在行
	private Integer lineNumber;
	//方法名称
	private String methodName;
	//微服务名称
	private String applicationName;
	//服务端口号
	private Integer port;
	//创建时间
	private String createDate;
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
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Integer getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(Integer lineNumber) {
		this.lineNumber = lineNumber;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
	public String getApplicationName() {
		return applicationName;
	}
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public String getExceptionName() {
		return exceptionName;
	}
	public void setExceptionName(String exceptionName) {
		this.exceptionName = exceptionName;
	}
	
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "Message [code=" + code + ", msg=" + msg + ", exceptionName=" + exceptionName + ", className="
				+ className + ", fileName=" + fileName + ", lineNumber=" + lineNumber + ", methodName=" + methodName
				+ ", applicationName=" + applicationName + ", port=" + port + ", createDate=" + createDate + "]";
	}
	
	
}
