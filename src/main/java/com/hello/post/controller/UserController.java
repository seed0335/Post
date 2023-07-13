package com.hello.post.controller;

import com.hello.post.dto.SignupDto;
import com.hello.post.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/post/user")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 회원가입 이동
    @GetMapping("/signup")
    public String home() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute @Valid SignupDto signupDto, BindingResult bindingResult) {
        log.info("signup={}", signupDto);

        if(bindingResult.hasErrors()) {
            log.info("bindingResult={}", bindingResult);
            return "signup";
        }

        try {
            userService.signup(signupDto);
        } catch (Exception e) {
            e.printStackTrace();
            return "signup";
        }

        return "login";
    }

}