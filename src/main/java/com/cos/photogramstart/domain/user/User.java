package com.cos.photogramstart.domain.user;


//JPA - Java Persistence API (자바로 데이터를 영구적으로 저장(DB) 할 수 있는 API를 제공)

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor // 전체 생성자
@NoArgsConstructor // 빈 생성자
@Data
@Entity //DB 테이블 생성
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //번호 자동증가
    private int id;

    @Column(length = 20, unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;

    private String website; //웹사이트
    private String bio; //자기소개
    @Column(nullable = false)
    private String email;
    private String phone;
    private String gender;

    private String profileImageUrl; //프로필사진
    private String role; //권한

    private LocalDateTime createDate;

    @PrePersist //DB insert전 실행
    public void createDate() {
        this.createDate = LocalDateTime.now();
    }

}
