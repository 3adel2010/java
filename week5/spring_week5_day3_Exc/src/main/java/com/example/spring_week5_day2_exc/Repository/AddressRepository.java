package com.example.spring_week5_day2_exc.Repository;

import com.example.spring_week5_day2_exc.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer>
{
    Address findAddressById(Integer id);
}
