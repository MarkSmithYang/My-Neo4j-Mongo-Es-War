package com.ddb.demo.neo4j.exception;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.neo4j.ogm.model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.alibaba.fastjson.JSONObject;

@Profile({"dev","test"})
@RestControllerAdvice
public class GlobalExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody // 在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
	public JSONObject methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e,
			HttpServletResponse response) {
		JSONObject resp = new JSONObject();
		resp.put("status", HttpStatus.BAD_REQUEST.value());
		FieldError fieldError = e.getBindingResult().getFieldError();
		String message = null;
		if (fieldError != null) {
			message = fieldError.getDefaultMessage();
		} else {
			message = e.getMessage();
		}
		resp.put("message", message);
		return resp;
	}

    /**
        * @Description:接口单个参数的校验捕捉处理
        * @author biaoyang
        * @date 2018/8/15 0015 14:32
        */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public JSONObject handleValidationException(ConstraintViolationException e) {
        for (ConstraintViolation<?> s : e.getConstraintViolations()) {
            JSONObject resp = new JSONObject();
    		resp.put("status", HttpStatus.BAD_REQUEST.value());
    		resp.put("message", s.getMessage());
    		return resp;
        }
        return null;
    }

	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(ErrorTokenException.class)
	@ResponseBody // 在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
	public JSONObject errorTokenExceptionHandler(ErrorTokenException e, HttpServletResponse response) {
		JSONObject resp = new JSONObject();
		resp.put("status", HttpStatus.UNAUTHORIZED.value());
		resp.put("message", e.getMessage());
		return resp;
	}

	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(ParameterErrorException.class)
	@ResponseBody // 在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
	public JSONObject parameterErrorExceptionHandler(ParameterErrorException e, HttpServletResponse response) {
		JSONObject resp = new JSONObject();
		resp.put("status", HttpStatus.BAD_REQUEST.value());
		resp.put("message", e.getMessage());
		return resp;
	}

	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseBody // 在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
	public JSONObject methodArgumentTypeMismatchExceptionHandler(HttpRequestMethodNotSupportedException e,
			HttpServletResponse response) {
		JSONObject resp = new JSONObject();
		resp.put("status", HttpStatus.BAD_REQUEST.value());
		resp.put("message", e.getMessage());
		logger.error(e.getMessage(), e);
		return resp;
	}

	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler({ MethodArgumentTypeMismatchException.class, HttpMessageNotReadableException.class })
	@ResponseBody // 在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
	public JSONObject methodArgumentTypeMismatchExceptionHandler(MethodArgumentTypeMismatchException e,
			HttpServletResponse response) {
		JSONObject resp = new JSONObject();
		resp.put("status", HttpStatus.BAD_REQUEST.value());
		resp.put("message", "参数类型不对");
		logger.error(e.getMessage(), e);
		return resp;
	}

	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(MissingServletRequestParameterException.class)
	@ResponseBody // 在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
	public JSONObject missingServletRequestParameterExceptionHandler(MissingServletRequestParameterException e,
			HttpServletResponse response) {
		JSONObject resp = new JSONObject();
		resp.put("status", HttpStatus.BAD_REQUEST.value());
		resp.put("message", e.getMessage());
		logger.error(e.getMessage(), e);
		return resp;
	}

	@ExceptionHandler(RetryTimesException.class)
	@ResponseBody // 在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
	public JSONObject retryTimesExceptionHandler(RetryTimesException e, HttpServletResponse response) {
		JSONObject resp = new JSONObject();
		resp.put("status", HttpStatus.BAD_REQUEST.value());
		resp.put("message", e.getMessage());
		resp.put("leftTime", e.getWaitTime());
		return resp;
	}

	 @ExceptionHandler(RuntimeException.class)
	 @ResponseBody // 在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
	 public MyExceptionResponse exceptionHandler(RuntimeException e,
	 HttpServletResponse response) {
	 MyExceptionResponse resp = new MyExceptionResponse();
	 resp.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
	 resp.setMessage("网络异常");
	 logger.error(e.getMessage(), e);
	 return resp;
	 }
	
	 @ExceptionHandler(Exception.class)
	 @ResponseBody // 在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
	 public MyExceptionResponse exceptionHandler(Exception e, HttpServletResponse
	 response) {
	 MyExceptionResponse resp = new MyExceptionResponse();
	 resp.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
	 resp.setMessage("网络异常");
	 logger.error(e.getMessage(), e);
	 return resp;
	 }

}
