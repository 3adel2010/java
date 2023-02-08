package com.example.spring_week5_day2_exc.Controller;

import com.example.spring_week5_day2_exc.Model.Course;
import com.example.spring_week5_day2_exc.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController
{
    private final CourseService courseService;
    @GetMapping("/get")
    public ResponseEntity getCourse()
    {
        List<Course> courseList = courseService.getCourse();
        return ResponseEntity.status(200).body(courseList);
    }
    @PostMapping("/add")
    public ResponseEntity addCourse(@Valid @RequestBody Course course)
    {
        courseService.addCourse(course);
        return ResponseEntity.status(200).body("Course added!");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id,@Valid @RequestBody Course course)
    {
        courseService.updateCourse(id, course);
        return ResponseEntity.status(200).body("Course updated!");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id)
    {
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body("Course deleted!");
    }
    @PutMapping("/teacher/{t_Id}/course/{c_Id}")
    public ResponseEntity linkTeacherWithCourse(@PathVariable Integer t_Id,@PathVariable Integer c_Id)
    {
        courseService.linkTeacherWithCourse(t_Id,c_Id);
        return ResponseEntity.status(200).body("Teacher linked with course");
    }
    @GetMapping("/getTeacher/{id}")
    public ResponseEntity getTeacherName(@PathVariable Integer id)
    {
        String getTeacher = courseService.getTeacherName(id);
        return ResponseEntity.status(200).body(getTeacher);
    }
}
