package com.cos.photogramstart.handler.ex;

import java.util.Map;

public class CustumValidationException extends RuntimeException {

    //객체 구분을 위해
    private static final long serialVersionUID = 1L;

    private Map<String, String> errorMap;

    public CustumValidationException(String message) {
        super(message);
    }
    public CustumValidationException(String message, Map<String, String> errorMap) {
        super(message);
        this.errorMap = errorMap;
    }

    public Map<String, String> getErrorMap() {
        return errorMap;
    }

}
