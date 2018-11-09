package com.ddb.demo.neo4j.common;

public class DataInfo<T> extends BaseInfo {	
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	public static <T> DataInfo<T> success(T t){
		DataInfo<T> result = new DataInfo<>();
		result.setStatus(SUCCESS_CODE);
		result.setMessage(SUCCESS_MESSAGE);
		result.setData(t);
		return result;
	}

	public static <T> DataInfo<T> error(String message){
		DataInfo<T> result = new DataInfo<>();
		result.setStatus(ERROR_CODE);
		result.setMessage(message);
		return result;
	}
}
