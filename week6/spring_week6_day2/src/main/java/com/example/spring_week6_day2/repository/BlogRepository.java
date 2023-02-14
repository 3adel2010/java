package com.example.spring_week6_day2.repository;

import com.example.spring_week6_day2.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer>
{
    Blog findBlogById(Integer id);
    Blog findByTitle(String title);
    @Query("select  b from  Blog  b where b.myUser.id=?1")
    List<Blog> getMyBlogs(Integer id);
}
