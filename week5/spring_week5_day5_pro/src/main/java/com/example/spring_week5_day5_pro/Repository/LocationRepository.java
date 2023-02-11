package com.example.spring_week5_day5_pro.Repository;

import com.example.spring_week5_day5_pro.Model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location,Integer>
{
    Location findLocationById(Integer id);
}
