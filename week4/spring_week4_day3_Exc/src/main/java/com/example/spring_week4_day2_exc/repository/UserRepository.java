package com.example.spring_week4_day2_exc.repository;

import com.example.spring_week4_day2_exc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>
{
    User findUserByEmail(String email);
    List<User> findUserByRole(String role);
    @Query("select a from User a where a.userName = ?1 and a.password = ?2")
    User findIdForMe(String  username,String password);
    @Query("select a from User a where a.age >= ?1")
    List<User> findSpecificAge(Integer age);
}
