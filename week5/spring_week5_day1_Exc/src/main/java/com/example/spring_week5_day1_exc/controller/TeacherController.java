package com.example.spring_week5_day1_exc.controller;

import com.example.spring_week5_day1_exc.model.Teacher;
import com.example.spring_week5_day1_exc.service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController
{
    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getTeacher()
    {
        List<Teacher> teacherList = teacherService.getTeacher();
        return ResponseEntity.status(200).body(teacherList);
    }
    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher)
    {
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body("Teacher added!");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id,@Valid @RequestBody Teacher teacher)
    {
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.status(200).body("Teacher updated!");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id)
    {
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body("Teacher delete!");
    }
}
