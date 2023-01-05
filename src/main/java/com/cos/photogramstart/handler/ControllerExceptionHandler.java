package com.cos.photogramstart.handler;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.handler.ex.CustumValidationApiException;
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

    //javascript return
    @ExceptionHandler(CustumValidationException.class)
    public String validationException(CustumValidationException e) {
        //CMRespDTO, Script 비교
        //1.클라이언트에게 응답은 script가 좋음
        //2.ajax통신 - CMRespDTO
        //3.Andriod통신 - CMRespDTO
        return Script.back(e.getErrorMap().toString());
    }

    //object return
    @ExceptionHandler(CustumValidationException.class)
    public CMResponseDTO<?> validationApiException(CustumValidationApiException e) {
        return new CMResponseDTO<>(-1, e.getMessage(), e.getErrorMap());
    }
}
