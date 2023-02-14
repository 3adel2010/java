package com.example.spring_week6_day2.controller;

import com.example.spring_week6_day2.model.Blog;
import com.example.spring_week6_day2.model.MyUser;
import com.example.spring_week6_day2.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blog")
@RequiredArgsConstructor
public class BlogController
{
    private final BlogService blogService;
    @GetMapping("/get")
    public ResponseEntity getBlog(@AuthenticationPrincipal MyUser myUser)
    {
        List<Blog> bLogList = blogService.getBlog(myUser);
        return ResponseEntity.status(HttpStatus.OK).body(bLogList);
    }
    @PostMapping("/add")
    public ResponseEntity addBlog(@AuthenticationPrincipal MyUser myUser, @RequestBody Blog blog)
    {
        blogService.addBlog(myUser,blog);
        return ResponseEntity.status(HttpStatus.OK).body("Blog added !");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateBlog(@AuthenticationPrincipal MyUser myUser, @PathVariable Integer id, @RequestBody Blog blog)
    {
        boolean isOk = blogService.updateBlog(myUser,id,blog);
        if(isOk)
            return ResponseEntity.status(400).body("Wrong id !");
        return ResponseEntity.status(HttpStatus.OK).body("Blog updated !");
    }
    @DeleteMapping
    public ResponseEntity deleteBlog(@AuthenticationPrincipal MyUser myUser, @RequestBody Integer id)
    {
        boolean isOk = blogService.deleteBlog(id,myUser);
        if(isOk)
            return ResponseEntity.status(400).body("Wrong id !");
        return ResponseEntity.status(HttpStatus.OK).body("Blog deleted !");
    }
    @GetMapping("/getBlog/{id}")
    public ResponseEntity getBlog(@PathVariable Integer id){
        Blog blog=blogService.getBlog(id);
        return ResponseEntity.status(200).body(blog);
    }

    @GetMapping("/getBlogByTitle/{title}")
    public ResponseEntity getBlog(@PathVariable String title){
        Blog blog=blogService.getBlogByTitle(title);
        return ResponseEntity.status(200).body(blog);
    }
}
