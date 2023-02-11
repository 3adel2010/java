package com.example.spring_week5_day2_exc.Service;

import com.example.spring_week5_day2_exc.ApiException.ApiException;
import com.example.spring_week5_day2_exc.Model.Course;
import com.example.spring_week5_day2_exc.Model.Student;
import com.example.spring_week5_day2_exc.Repository.CourseRepository;
import com.example.spring_week5_day2_exc.Repository.StudentRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService
{
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final CourseService courseService;

    public List<Student> getStudent()
    {
        return studentRepository.findAll();
    }
    public void addStudent(Student student)
    {
        studentRepository.save(student);
    }
    public boolean updateStudent(Integer id, Student student)
    {
        Student student1 = studentRepository.findStudentById(id);
        if(student1==null)
            return false;
        student.setId(id);
        studentRepository.save(student);
        return true;
    }
    public boolean deleteStudent(Integer id)
    {
        Student student = studentRepository.findStudentById(id);
        if(student==null)
            return false;
        studentRepository.delete(student);
        return true;
    }

    public void assignStudentWithCourse(Integer student_Id,Integer course_Id)
    {
        Student student = studentRepository.findStudentById(student_Id);
        Course course = courseRepository.findCourseById(course_Id);
        if(student==null||course==null)
            throw new ApiException("Id not found!");
        student.getCourse().add(course);
        course.getStudent().add(student);
        studentRepository.save(student);
        courseRepository.save(course);
    }
    public void deleteCourses(Integer student_Id, String major)
    {
        Student student = studentRepository.findStudentById(student_Id);
        if(student==null)
            throw new ApiException("Wrong Id!");

        student.setMajor(major);
        List<Course> courseList = new ArrayList<>();

        for (int i = 0; i < student.getCourse().size(); i++)
        {
            courseList.add(student.getCourse().get(i));
        }

        for (int i = 0; i < student.getCourse().size(); i++)
        {
            student.getCourse().remove(student.getCourse().get(i));
            studentRepository.save(student);
        }
        for (int i = 0; i < courseList.size(); i++)
        {
            courseList.get(i).getStudent().remove(student);
            courseRepository.save(courseList.get(i));
        }
    }

    public List<Student> getStudentByCourseId(Integer course_Id)
    {
        Course course = courseRepository.findCourseById(course_Id);
        if(course==null)
            throw new ApiException("Wrong Id!");
        List<Student> ss = new ArrayList();
        for (Student s: course.getStudent())
        {
            ss.add(s);
        }
        return ss;
    }
}
