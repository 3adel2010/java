package com.example.spring_week5_day1_exc.controller;

import com.example.spring_week5_day1_exc.DTO.TeacherDTO;
import com.example.spring_week5_day1_exc.model.Address;
import com.example.spring_week5_day1_exc.service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController
{
    private final AddressService addressService;

    @GetMapping("/get")
    public ResponseEntity getAddress()
    {
        List<Address> addressList = addressService.getAddress();
        return ResponseEntity.status(200).body(addressList);
    }
    @PostMapping("/add")
    public ResponseEntity addAddress(@Valid @RequestBody Address address)
    {
        addressService.addAddress(address);
        return ResponseEntity.status(200).body("Address added!");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateAddress(@PathVariable Integer id, @Valid @RequestBody Address address)
    {
        addressService.updateAddress(id, address);
        return ResponseEntity.status(200).body("Address updated!");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id)
    {
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body("Address deleted!");
    }
    @PostMapping("/addDTO")
    public ResponseEntity addAddressDTO(@Valid @RequestBody TeacherDTO teacherDTO)
    {
        addressService.addAddressDTO(teacherDTO);
        return ResponseEntity.status(200).body("Address added!");
    }
    @PutMapping("/updateDTO")
    public ResponseEntity updateAddressDTO(@Valid @RequestBody TeacherDTO teacherDTO)
    {
        addressService.updateAddressDTO(teacherDTO);
        return ResponseEntity.status(200).body("Address updated!");
    }
    @DeleteMapping("/deleteDTO/{id}")
    public ResponseEntity deleteAddressDTO(@PathVariable Integer id)
    {
        addressService.deleteAddressDTO(id);
        return ResponseEntity.status(200).body("Address deleted!");
    }
}
