package com.cos.photogramstart.web.dto.auth;

import com.cos.photogramstart.domain.user.User;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Data
public class SignupDTO {

    @Max(20)
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String email;
    @NotBlank
    private String name;

    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .name(name)
                .build();
    }

}
