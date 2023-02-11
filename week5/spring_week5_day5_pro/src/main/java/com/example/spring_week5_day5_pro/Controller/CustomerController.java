package com.example.spring_week5_day5_pro.Controller;

import com.example.spring_week5_day5_pro.Model.Customer;
import com.example.spring_week5_day5_pro.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController
{
    private final CustomerService customerService;
    @GetMapping("/get")
    public ResponseEntity getCustomer()
    {
        List<Customer> customerList = customerService.getCustomer();
        return ResponseEntity.status(200).body(customerList);
    }
    @PostMapping("/add")
    public ResponseEntity addCustomer(@Valid @RequestBody Customer customer)
    {
        customerService.addCustomer(customer);
        return ResponseEntity.status(200).body("Customer added!");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateCustomer(@PathVariable Integer id,@Valid @RequestBody Customer customer)
    {
        customerService.updateCustomer(id, customer);
        return ResponseEntity.status(200).body("Customer updated!");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id)
    {
        customerService.deleteCustomer(id);
        return ResponseEntity.status(200).body("Customer deleted!");
    }
    @PutMapping("/{customerId}/store/{storeId}")
    public ResponseEntity assignStoreWithCustomers(@PathVariable Integer storeId,@PathVariable Integer customerId)
    {
        customerService.assignStoreWithCustomers(storeId,customerId);
        return ResponseEntity.status(200).body("Store assigned with customers");

    }
    @GetMapping("/racbs/{id}")
    public ResponseEntity returnAllCustomersByStore(@PathVariable Integer id)
    {
        List<String> bookList = customerService.returnAllCustomersByStore(id);
        return ResponseEntity.status(200).body(bookList);
    }
}
