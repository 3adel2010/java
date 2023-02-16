package com.example.spring_week6_day3.repository;

import com.example.spring_week6_day3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>
{
    User findUsersById(Integer id);
    User findUsersByUsername(String username);
}
