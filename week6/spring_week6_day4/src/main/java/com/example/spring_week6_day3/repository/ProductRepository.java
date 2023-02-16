package com.example.spring_week6_day3.repository;

import com.example.spring_week6_day3.model.Product;
import com.example.spring_week6_day3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>
{
    Product findProductById(Integer id);
    @Query("select  b from  Product  b where b.id=?1")
    List<Product> getMyProducts(Integer id);
}
