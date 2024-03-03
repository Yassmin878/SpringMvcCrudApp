package com.adminPanel.app.controller;

import com.adminPanel.app.exceptioNResponse.ProductErrorResponse;
import com.adminPanel.app.exceptioNResponse.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class productNotFoundExceptionHandler
{

    @ExceptionHandler
    public ResponseEntity<ProductErrorResponse>HandlerForNotFound(ProductNotFoundException exception)
    {
        ProductErrorResponse errorResponse=new ProductErrorResponse();

        errorResponse.setCode(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTime(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
    
}
