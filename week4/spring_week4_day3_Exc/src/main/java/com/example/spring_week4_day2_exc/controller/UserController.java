package com.example.spring_week4_day2_exc.controller;

import com.example.spring_week4_day2_exc.model.User;
import com.example.spring_week4_day2_exc.servise.UserServise;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController
{
    private final UserServise userServise;

    @GetMapping("/get")
    public ResponseEntity getUser()
    {
        List<User> userList= userServise.getUser();
        return ResponseEntity.status(200).body(userList);
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user)
    {
        userServise.addUser(user);
        return ResponseEntity.status(200).body("User add!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id,@Valid@RequestBody User user)
    {
        userServise.updateUser(id,user);
        return ResponseEntity.status(200).body("User updated!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id)
    {
        userServise.deleteUser(id);
        return ResponseEntity.status(200).body("User deleted!");
    }

    @GetMapping("/byEmail/{email}")
    public ResponseEntity findUserByEmail(@PathVariable String  email)
    {
        User user = userServise.findUserByEmail(email);
        return ResponseEntity.status(200).body(user);
    }

    @GetMapping("/UsernameAndPassword")
    public ResponseEntity findUsernameAndPassword(@RequestBody User user)
    {
        userServise.findUsernameAndPassword(user);
        return ResponseEntity.status(200).body("Welcome back");
    }
    @GetMapping("/byRole/{role}")
    public ResponseEntity findUserByRole(@PathVariable String role)
    {
        List<User> user = userServise.findUserByRole(role);
        return ResponseEntity.status(200).body(user);
    }
    @GetMapping("/specificAge/{age}")
    public ResponseEntity findSpecificAge(@PathVariable Integer age)
    {
        List<User> user = userServise.findSpecificAge(age);
        return ResponseEntity.status(200).body(user);
    }
}
