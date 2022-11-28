package com.cos.photogramstart.web.api;

import com.cos.photogramstart.config.auth.PrincipalDetails;
import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.service.UserService;
import com.cos.photogramstart.web.dto.CMResponseDTO;
import com.cos.photogramstart.web.dto.user.UserUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PutMapping("/api/user/{id}")
    public CMResponseDTO<?> update(@PathVariable int id, UserUpdateDTO userUpdateDTO, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        User userEntity = userService.회원수정(id, userUpdateDTO.toEntity());
        principalDetails.setUser(userEntity); //세션정보 변경
        return new CMResponseDTO<>(1, "회원수정완료", userEntity);
    }

}
