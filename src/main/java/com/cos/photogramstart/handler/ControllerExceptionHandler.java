package com.cos.photogramstart.handler;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.handler.ex.CustumValidationException;
import com.cos.photogramstart.util.Script;
import com.cos.photogramstart.web.dto.CMResponseDTO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@ControllerAdvice
public class ControllerExceptionHandler {

    /**
     * DTO -> 개발자
     * Script -> 유저(브라우저, 클라이언트) : 보통은 프론트에서 처리
     */

    /*
    @ExceptionHandler(CustumValidationException.class)
    public CMResponseDTO<?> validationException(CustumValidationException e) {
        return new CMResponseDTO<Map<String,String>>(-1, e.getMessage(), e.getErrorMap());
    }
    */

    @ExceptionHandler(CustumValidationException.class)
    public String validationException(CustumValidationException e) {
        return Script.back(e.getErrorMap().toString());
    }
}
