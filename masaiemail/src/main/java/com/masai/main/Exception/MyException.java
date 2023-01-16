package com.masai.main.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;

public class MyException {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex, WebRequest req){
        ErrorMessage error=new ErrorMessage();
        error.setError_message(ex.getMessage());
        error.setError_time(LocalDateTime.now());
        error.setUri_details(req.getDescription(false));
        return new ResponseEntity<ErrorMessage>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> validException(MethodArgumentNotValidException ex){
        ErrorMessage error=new ErrorMessage();
        error.setError_message("Validation Error");
        error.setError_time(LocalDateTime.now());
        error.setUri_details(ex.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<ErrorMessage>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<?> noHandler(NoHandlerFoundException ex,WebRequest req){
        ErrorMessage error=new ErrorMessage();
        error.setError_message(ex.getMessage());
        error.setError_time(LocalDateTime.now());
        error.setUri_details(req.getDescription(false));
        return new ResponseEntity<ErrorMessage>(error,HttpStatus.NOT_FOUND);
    }
}
