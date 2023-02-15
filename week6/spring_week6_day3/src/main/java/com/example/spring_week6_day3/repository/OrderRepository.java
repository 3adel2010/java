package com.example.spring_week6_day3.repository;

import com.example.spring_week6_day3.model.Orders;
import com.example.spring_week6_day3.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer>
{
    Orders findOrderById(Integer id);

    @Query("select  b from  Orders  b where b.id=?1")
    List<Orders> getMyProducts(Integer id);
}
