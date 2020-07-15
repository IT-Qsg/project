package com.dfec.springbootmybatis.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/8 16:54
 * @describe
 **/
@ControllerAdvice
public class UserExceptionController {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> exception(UserNotFoundException usernotfoundexception){
        return new ResponseEntity<>("user not found", HttpStatus.NOT_FOUND);
    }
}
