package com.example.spring_week5_day2_exc.Repository;

import com.example.spring_week5_day2_exc.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer>
{
    Teacher findTeacherById(Integer id);
}
