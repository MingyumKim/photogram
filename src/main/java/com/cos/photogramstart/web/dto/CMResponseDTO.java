package com.cos.photogramstart.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CMResponseDTO<T> {

    private int code; //식별 값(코드) 1:성공, -1:실패
    private String message;
    private T data;

}
