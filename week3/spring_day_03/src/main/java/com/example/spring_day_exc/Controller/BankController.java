package com.example.spring_day_exc.Controller;

import com.example.spring_day_exc.Api.ApiResponse;
import com.example.spring_day_exc.Pojo.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/bank")
public class BankController
{
    private ArrayList<Bank> banks = new ArrayList<>();
@GetMapping("/get")
    public ArrayList<Bank> getCustomers()
    {
        return banks;
    }
    @PostMapping("/add")
    public ApiResponse addCustomer(@RequestBody Bank bank)
    {
        banks.add(bank);
        return new ApiResponse("Cusomer added");
    }
@PutMapping("/update/{index}")
    public ApiResponse updateCustomer(@PathVariable int index,@RequestBody Bank bank)
    {
        banks.set(index,bank);
        return new ApiResponse("Customer updated");
    }
@DeleteMapping("/delete/{index}")
    public ApiResponse deleteCustomer(@PathVariable int index)
    {
        banks.remove(index);
        return new ApiResponse("Customer deleted");
    }
@PutMapping("/deposit/{index}")
    public ApiResponse deposit(@PathVariable int index,@RequestBody double dep)
    {
        Bank bank1 = banks.get(index);
        double dep2 = bank1.getBalance() + dep;
        bank1.setBalance(dep2);
        return new ApiResponse("Deposit successful");
    }

    @PutMapping("/withdraw/{index}")
    public ApiResponse withdraw(@PathVariable int index,@RequestBody double dep)
    {
        Bank bank1 = banks.get(index);
        double dep2 = bank1.getBalance() - dep;
        bank1.setBalance(dep2);
        return new ApiResponse("Deposit successful");
    }
}
