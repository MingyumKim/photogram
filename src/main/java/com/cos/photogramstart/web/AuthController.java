package com.cos.photogramstart.web;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.service.AuthService;
import com.cos.photogramstart.web.dto.auth.SignupDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor //final 필드를 DI 할 때 사용
@Controller // 1.IoC 2.파일을 리턴하는 컨트롤러
public class AuthController {

    private final AuthService authService;

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    @GetMapping("/auth/signin")
    public String signinForm() {
        return "auth/signin";
    }

    @GetMapping("/auth/signup")
    public String signupForm() {
        return "auth/signup";
    }

    @PostMapping("/auth/signup")
    public String signup(@Valid SignupDTO signupDTO, BindingResult bindingResult) { //key = value
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error : bindingResult.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
                System.out.println("==================================");
                System.out.println(error.getDefaultMessage());
                System.out.println("==================================");
            }
        }

        User user = signupDTO.toEntity();
        User userEntity = authService.join(user);
        System.out.println(userEntity);

        return "auth/signin";
    }
}
