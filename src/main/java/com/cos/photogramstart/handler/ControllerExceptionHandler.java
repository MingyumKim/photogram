package com.cos.photogramstart.handler;

import com.cos.photogramstart.handler.ex.CustumValidationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(CustumValidationException.class)
    public Map<String, String> validationException(CustumValidationException e) {
        return e.getErrorMap();
    }
}
