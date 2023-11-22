package com.hyuk.jpaboardcrud.controller;

import com.hyuk.jpaboardcrud.dto.UserRequestDto;
import com.hyuk.jpaboardcrud.entity.User;
import com.hyuk.jpaboardcrud.repository.UserRepository;
import com.hyuk.jpaboardcrud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    //회원가입
    @PostMapping("/signup")
    public UserRequestDto register(@RequestBody UserRequestDto requestDto) {
        userService.register(requestDto);
        return requestDto;
    }

//    @PostMapping("/loging")
//    public String login(@RequestBody LoginRequestDto requestDto) {
//        User member = userRepository.findByUsername(requestDto.getUsername())
//                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 회원입니다."));
//        // 비밀번호 복호화(passwordEncoder사용)
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        if (passwordEncoder.matches(member.getPassword(), requestDto.getPassword())) {
//            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
//        }
//        return jwtTokenProvider.createToke(member.getUsername());
//    }
}
