package com.handler.tracker.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler
  public ResponseEntity handleException(Exception e){
//    e.printStackTrace();
    if(e instanceof MethodArgumentNotValidException) {
      List<String> errors = new ArrayList<>();
      ((MethodArgumentNotValidException) e).getBindingResult().getAllErrors().forEach(objectError ->  {
        errors.add(objectError.getDefaultMessage());
      });
      return new ResponseEntity<>(new ApiResponse(false, "", errors), HttpStatus.BAD_REQUEST);
    }

    if (e instanceof ArithmeticException) {
      return new ResponseEntity<>(new ApiResponse(false, e.getMessage(), ""), HttpStatus.BAD_REQUEST);
    }

    if (e instanceof RuntimeException) {
      return new ResponseEntity<>(new ApiResponse(false, e.getMessage(), ""), HttpStatus.BAD_REQUEST);
    }
    return null;
  }

}
