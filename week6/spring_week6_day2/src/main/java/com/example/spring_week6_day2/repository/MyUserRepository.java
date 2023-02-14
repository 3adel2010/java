package com.example.spring_week6_day2.repository;

import com.example.spring_week6_day2.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser,Integer>
{
    MyUser findMyUserById(Integer id);
    MyUser findMyUserByUsername(String title);
}
