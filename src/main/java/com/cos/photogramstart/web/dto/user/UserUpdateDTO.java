package com.cos.photogramstart.web.dto.user;

import com.cos.photogramstart.domain.user.User;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserUpdateDTO {
    @NotBlank
    private String name; //필수
    @NotBlank
    private String password; //필수
    private String website; //필수
    private String bio;
    private String phone;
    private String gender;

    //코드 수정이 필요할 예정
    public User toEntity(){
        return User.builder()
                .name(name) //필수 값이라 validation check필요
                .password(password) //필수 값이라 validation check필요
                .website(website)
                .bio(bio)
                .phone(phone)
                .gender(gender)
                .build();
    }
}
