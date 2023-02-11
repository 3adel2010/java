package com.example.spring_week5_day2_exc.Service;

import com.example.spring_week5_day2_exc.ApiException.ApiException;
import com.example.spring_week5_day2_exc.DTO.TeacherDTO;
import com.example.spring_week5_day2_exc.Model.Address;
import com.example.spring_week5_day2_exc.Model.Teacher;
import com.example.spring_week5_day2_exc.Repository.AddressRepository;
import com.example.spring_week5_day2_exc.Repository.TeacherRepository;
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
    public boolean updateAddress(Integer id,Address address)
    {
        Address address1 = addressRepository.findAddressById(id);
        if(address1==null)
            return false;
        address.setId(id);
        addressRepository.save(address);
        return true;
    }
    public boolean deleteAddress(Integer id)
    {
        Address address = addressRepository.findAddressById(id);
        if(address==null)
            return false;
        addressRepository.delete(address);
        return true;
    }
    public void addDTO(TeacherDTO teacherDTO)
    {
        Teacher teacher = teacherRepository.findTeacherById(teacherDTO.getTeacher_Id());
        if(teacher==null)
            throw new ApiException("ID not found!");
        Address address = new Address(null,teacherDTO.getStreet(),teacherDTO.getBuildingNumber(),teacher);
        addressRepository.save(address);
    }
    public void updateDTO(TeacherDTO teacherDTO)
    {
        Address address = addressRepository.findAddressById(teacherDTO.getTeacher_Id());
        if(address==null)
            throw new ApiException("ID not found!");
        address.setStreet(teacherDTO.getStreet());
        address.setBuildingNumber(teacherDTO.getBuildingNumber());
        addressRepository.save(address);
    }
    public void deleteDTO(Integer id)
    {
        Address address = addressRepository.findAddressById(id);
        if(address==null)
            throw new ApiException("ID not found!");
        addressRepository.delete(address.getTeacher().getAddress());
    }
}
