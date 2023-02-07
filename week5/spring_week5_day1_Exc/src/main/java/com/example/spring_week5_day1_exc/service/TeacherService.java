package com.example.spring_week5_day1_exc.service;

import com.example.spring_week5_day1_exc.model.Teacher;
import com.example.spring_week5_day1_exc.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService
{
    private final TeacherRepository teacherRepository;

    public List<Teacher> getTeacher()
    {
        return teacherRepository.findAll();
    }
    public void addTeacher(Teacher teacher)
    {
        teacherRepository.save(teacher);
    }
    public boolean updateTeacher(Integer id, Teacher teacher)
    {
        Teacher teacher1 = teacherRepository.findTeacherById(id);
        if(teacher1 == null)
            return false;
        teacher.setId(id);
        teacherRepository.save(teacher);
        return true;
    }
    public boolean deleteTeacher(Integer id)
    {
        Teacher teacher = teacherRepository.findTeacherById(id);
        if(teacher == null)
            return false;
        teacherRepository.delete(teacher);
        return true;
    }
}
