package com.example.spring_week4_day4_exc.repository;

import com.example.spring_week4_day4_exc.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director,Integer>
{
    Director findAllByName(String name);
    Director findAllByIdEquals(Integer id);
}
