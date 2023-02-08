package com.example.spring_week5_day2_exc.Service;

import com.example.spring_week5_day2_exc.ApiException.ApiException;
import com.example.spring_week5_day2_exc.Model.Course;
import com.example.spring_week5_day2_exc.Model.Teacher;
import com.example.spring_week5_day2_exc.Repository.CourseRepository;
import com.example.spring_week5_day2_exc.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService
{
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final TeacherService teacherService;
    public List<Course> getCourse()
    {
        return courseRepository.findAll();
    }
    public void addCourse(Course course)
    {
        courseRepository.save(course);
    }
    public boolean updateCourse(Integer id,Course course)
    {
        Course course1 = courseRepository.findCourseById(id);
        if(course1==null)
            return false;
        course.setId(id);
        courseRepository.save(course);
        return true;
    }
    public boolean deleteCourse(Integer id)
    {
        Course course = courseRepository.findCourseById(id);
        if(course==null)
            return false;
        courseRepository.delete(course);
        return true;
    }

    public void linkTeacherWithCourse(Integer teacher_Id,Integer course_Id)
    {
        Teacher teacher = teacherRepository.findTeacherById(teacher_Id);
        Course course = courseRepository.findCourseById(course_Id);
        if(teacher==null || course==null)
            throw new ApiException("Id not found");
        course.setTeacher(teacher);
        courseRepository.save(course);
    }
    public String  getTeacherName(Integer id)
    {
        Course course = courseRepository.findCourseById(id);
        if(course==null)
            throw new ApiException("Id not found!");
        for (Teacher t:teacherService.getTeacher())
        {
            if(t.getId() == course.getTeacher().getId())
                return t.getName().toString();
        }
        return "Teacher not found!";
    }
}
