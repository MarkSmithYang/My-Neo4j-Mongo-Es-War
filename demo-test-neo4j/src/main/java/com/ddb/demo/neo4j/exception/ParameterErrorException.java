package com.ddb.demo.neo4j.exception;

import java.io.Serializable;

public class ParameterErrorException extends RuntimeException implements Serializable{
	private static final long serialVersionUID = 6570402401138524651L;


	//两个构造和一个静态方法一个提示信息参数
	
	public ParameterErrorException() {
		super();
	}

	public ParameterErrorException(String message) {
		super(message);
	}
	
	public static void message(String message) {
		throw new ParameterErrorException(message);
	}
}
