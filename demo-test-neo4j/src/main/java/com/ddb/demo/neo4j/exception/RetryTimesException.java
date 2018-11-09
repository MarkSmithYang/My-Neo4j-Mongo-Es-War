package com.ddb.demo.neo4j.exception;

/**
 * @author Administrator
 * 重试次数异常信息
 */
public class RetryTimesException extends RuntimeException{
	private static final long serialVersionUID = 3176312479370286854L;

	private Long waitTime;

	public Long getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(Long waitTime) {
		this.waitTime = waitTime;
	}

	//自己的无参构造
	public RetryTimesException() {
		super();
	}
	
	//继承父类构造?
	public RetryTimesException(String message) {
		super(message);
	}

	public RetryTimesException(Long waitTime,String message) {
		super(message);
		this.waitTime = waitTime;
	}
	
	
}
