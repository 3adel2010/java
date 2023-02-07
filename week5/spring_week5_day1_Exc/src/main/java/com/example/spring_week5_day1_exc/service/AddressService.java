package com.example.spring_week5_day1_exc.service;

import com.example.spring_week5_day1_exc.DTO.TeacherDTO;
import com.example.spring_week5_day1_exc.apiException.ApiException;
import com.example.spring_week5_day1_exc.model.Address;
import com.example.spring_week5_day1_exc.model.Teacher;
import com.example.spring_week5_day1_exc.repository.AddressRepository;
import com.example.spring_week5_day1_exc.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService
{
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<Address> getAddress()
    {
        return addressRepository.findAll();
    }
    public void addAddress(Address address)
    {
        addressRepository.save(address);
    }
    public boolean updateAddress(Integer id, Address address)
    {
        Address address1 = addressRepository.findAddressById(id);
        if(address1 == null)
            return false;
        address.setId(id);
        addressRepository.save(address);
        return true;
    }
    public boolean deleteAddress(Integer id)
    {
        Address address = addressRepository.findAddressById(id);
        if(address == null)
            return false;
        addressRepository.delete(address);
        return true;
    }
    public void  addAddressDTO(TeacherDTO teacherDTO)
    {
        Teacher teacher = teacherRepository.findTeacherById(teacherDTO.getTeacher_Id());
        if(teacher == null)
        {
            throw new ApiException("Teacher not found!");
        }
        Address address = new Address(null,teacherDTO.getArea(),teacherDTO.getStreet(),teacherDTO.getBuildingNumber(),teacher);
        addressRepository.save(address);
    }

    public void updateAddressDTO(TeacherDTO teacherDTO)
    {
        Address address = addressRepository.findAddressById(teacherDTO.getTeacher_Id());
        if(address == null)
            throw new ApiException("Address not found!");
        address.setArea(teacherDTO.getArea());
        address.setStreet(teacherDTO.getStreet());
        address.setBuildingNumber(teacherDTO.getBuildingNumber());
        addressRepository.save(address);
    }
    public void deleteAddressDTO(Integer id)
    {
        Address address =addressRepository.findAddressById(id);
        if(address == null)
            throw new ApiException("Address is not found!");
        addressRepository.delete(address.getTeacher().getAddress());
    }
}
