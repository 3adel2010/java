package com.example.spring_week6_day3.controller;

import com.example.spring_week6_day3.model.User;
import com.example.spring_week6_day3.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController
{

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid User user)
    {
        userService.register(user);
        return ResponseEntity.status(HttpStatus.OK).body("User registered !");
    }

    @PostMapping("/login")
    public ResponseEntity logIn()
    {
        return ResponseEntity.status(HttpStatus.OK).body("Welcome back !");
    }

    private final UserService userService;
    @GetMapping("/get")
    public ResponseEntity getUser()
    {
        List<User> userList = userService.getUser();
        return ResponseEntity.status(HttpStatus.OK).body(userList);
    }
    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody User user)
    {
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.OK).body("User added !");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody @Valid User user)
    {
        userService.updateUser(id, user);
        return ResponseEntity.status(HttpStatus.OK).body("User updated !");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id)
    {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("User deleted !");
    }
}
