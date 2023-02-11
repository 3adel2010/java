package com.example.spring_week5_day2_exc.Controller;

import com.example.spring_week5_day2_exc.Model.Teacher;
import com.example.spring_week5_day2_exc.Service.TeacherService;
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
        teacherService.updateTeacher(id,teacher);
        return ResponseEntity.status(200).body("Teacher updated!");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id)
    {
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body("Teacher deleted!");
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity getById(@PathVariable Integer id)
    {
        Teacher teacher = teacherService.getAllDetails(id);
        return ResponseEntity.status(200).body(teacher);
    }
}
