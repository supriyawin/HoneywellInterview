package com.interview.honeywell.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class IdCannotBeDuplicateException extends RuntimeException {

	public IdCannotBeDuplicateException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	

}
