package com.example.spring_week5_day5_pro.Repository;

import com.example.spring_week5_day5_pro.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>
{
    Customer findCustomerById(Integer id);
}
