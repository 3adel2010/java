package com.example.spring_week5_day5_pro.Service;

import com.example.spring_week5_day5_pro.ApiException.ApiException;
import com.example.spring_week5_day5_pro.Model.Book;
import com.example.spring_week5_day5_pro.Model.Customer;
import com.example.spring_week5_day5_pro.Model.Store;
import com.example.spring_week5_day5_pro.Repository.CustomerRepository;
import com.example.spring_week5_day5_pro.Repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService
{
    private final CustomerRepository customerRepository;
    private final StoreRepository storeRepository;
    public List<Customer> getCustomer()
    {
        return customerRepository.findAll();
    }
    public void addCustomer(Customer customer)
    {
        customerRepository.save(customer);
    }
    public boolean updateCustomer(Integer id,Customer customer)
    {
        Customer customer1 = customerRepository.findCustomerById(id);
        if(customer1==null)
            return false;
        customer.setId(id);
        customerRepository.save(customer);
        return true;
    }
    public boolean deleteCustomer(Integer id)
    {
        Customer customer = customerRepository.findCustomerById(id);
        if(customer==null)
            return false;
        customerRepository.delete(customer);
        return true;
    }
    public void assignStoreWithCustomers(Integer storeId,Integer customerId)
    {
        Store store = storeRepository.findStoreById(storeId);
        Customer customer = customerRepository.findCustomerById(customerId);
        if(store==null||customer==null)
            throw new ApiException("Id not found!");
        store.getCustomers().add(customer);
        customer.getStores().add(store);
        storeRepository.save(store);
        customerRepository.save(customer);
    }
    public List<String> returnAllCustomersByStore(Integer id)
    {
        Store store = storeRepository.findStoreById(id);
        if(store==null)
            throw new ApiException("Wrong id");

        List<String> customersName = new ArrayList<>();

        for (Customer c: store.getCustomers())
        {
            customersName.add(c.getName());
        }
        return customersName;
    }
}
