package com.example.spring_week5_day1_exc.repository;

import com.example.spring_week5_day1_exc.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer>
{
    Address findAllById(Integer id);
    Address findAddressById(Integer id);
}
