package com.example.payroll.exception;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mongodb.DuplicateKeyException;

/**
 * Created by yeo on 9/17/2017.
 */

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({ DuplicateKeyException.class })
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseEntity processLc4eException(HttpServletResponse request, HttpServletResponse response,
                                               DuplicateKeyException e) {

		String message = "Duplicated identity data found. " + e.getErrorMessage();
		String code = String.valueOf(e.getErrorCode());

		return new ResponseEntity(new ErrorMessage(code, message), HttpStatus.CONFLICT);
	}
}
