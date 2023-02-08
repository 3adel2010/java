package com.example.spring_week5_day2_exc.Repository;

import com.example.spring_week5_day2_exc.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer>
{
    Course findCourseById(Integer id);
}
