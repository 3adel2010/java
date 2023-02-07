package com.example.spring_week5_day1_exc.repository;

import com.example.spring_week5_day1_exc.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer>
{
    Teacher findAllById(Integer id);
    Teacher findTeacherById(Integer id);
}
