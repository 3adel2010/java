package com.example.spring_week5_day5_pro.Repository;

import com.example.spring_week5_day5_pro.Model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store,Integer>
{
    Store findStoreById(Integer id);
}
