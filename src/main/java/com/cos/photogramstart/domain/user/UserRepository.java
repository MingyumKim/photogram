package com.cos.photogramstart.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

//어노테이션이 없어도 IoC 자동 등록된다
public interface UserRepository extends JpaRepository<User, Integer> {
    //JPA query method
    User findByUsername(String username);

}
