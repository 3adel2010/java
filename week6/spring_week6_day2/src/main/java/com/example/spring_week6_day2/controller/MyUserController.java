package com.example.spring_week6_day2.controller;

import com.example.spring_week6_day2.model.MyUser;
import com.example.spring_week6_day2.service.MyUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/myuser")
@RequiredArgsConstructor
public class MyUserController
{
    private final MyUserService myUserService;

    @PostMapping("/register")
        public ResponseEntity register(@RequestBody @Valid MyUser myUser)
    {
        myUserService.register(myUser);
        return ResponseEntity.status(HttpStatus.OK).body("User registered !");
    }

    @PostMapping("/login")
    public ResponseEntity logIn()
    {
        return ResponseEntity.status(HttpStatus.OK).body("Welcome back !");
    }
}
