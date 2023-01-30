package com.example.spring_week4_day2_exc.repository;

import com.example.spring_week4_day2_exc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>
{

}
