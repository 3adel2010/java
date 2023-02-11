package com.example.spring_week5_day2_exc.Controller;

import com.example.spring_week5_day2_exc.Model.Student;
import com.example.spring_week5_day2_exc.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController
{
    private final StudentService studentService;
    @GetMapping("/get")
    public ResponseEntity getStudent()
    {
        List<Student> studentList = studentService.getStudent();
        return ResponseEntity.status(200).body(studentList);
    }
    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student)
    {
        studentService.addStudent(student);
        return ResponseEntity.status(200).body("Student added!");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id,@Valid @RequestBody Student student)
    {
        studentService.updateStudent(id, student);
        return ResponseEntity.status(200).body("Student updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id)
    {
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body("Student deleted!");
    }
    @PutMapping("/{s_Id}/course/{c_Id}")
    public ResponseEntity assignStudentWithCourse(@PathVariable Integer s_Id,@PathVariable Integer c_Id)
    {
        studentService.assignStudentWithCourse(s_Id,c_Id);
        return ResponseEntity.status(200).body("Assigned");
    }
    @PutMapping("/deleteCourses/{s_Id}/{major}")
    public ResponseEntity deleteCourses(@PathVariable Integer s_Id, @PathVariable String major)
    {
        studentService.deleteCourses(s_Id,major);
        return ResponseEntity.status(200).body("Courses deleted!");
    }
    @GetMapping("/getStudentByCourseId/{id}")
    public ResponseEntity getStudentByCourseId(@PathVariable Integer id)
    {
        List<Student> studentList = studentService.getStudentByCourseId(id);
        List<String > studentNames = new ArrayList<>();
        for (Student s:studentList)
        {
            studentNames.add(s.getName());
        }
        return ResponseEntity.status(200).body(studentNames);
    }
}
