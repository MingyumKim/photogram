package com.cos.photogramstart.web.api;

import com.cos.photogramstart.config.auth.PrincipalDetails;
import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.handler.ex.CustumValidationApiException;
import com.cos.photogramstart.handler.ex.CustumValidationException;
import com.cos.photogramstart.service.UserService;
import com.cos.photogramstart.web.dto.CMResponseDTO;
import com.cos.photogramstart.web.dto.user.UserUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PutMapping("/api/user/{id}")
    public CMResponseDTO<?> update(
            @PathVariable int id,
            @Valid UserUpdateDTO userUpdateDTO,
            BindingResult bindingResult, //꼭 valid가 적혀있는 다음 파라메터에 적어야함
            @AuthenticationPrincipal PrincipalDetails principalDetails) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error : bindingResult.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            throw new CustumValidationApiException("유효성 검사 실패", errorMap);
        } else {
            User userEntity = userService.회원수정(id, userUpdateDTO.toEntity());
            principalDetails.setUser(userEntity); //세션정보 변경
            return new CMResponseDTO<>(1, "회원수정완료", userEntity);
        }
    }
}
