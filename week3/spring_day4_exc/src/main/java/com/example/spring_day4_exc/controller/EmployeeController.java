package com.example.spring_day4_exc.controller;


import com.example.spring_day4_exc.pojo.Employee;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController
{
    ArrayList<Employee> employees = new ArrayList<>();
    @GetMapping("/get")
    public ArrayList<Employee> getEmployees()
    {
        return employees;
    }
@PostMapping("/add")
    public ResponseEntity addEmployee(@Valid @RequestBody Employee employee,Errors errors)
    {
        if(errors.hasErrors())
        {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        employees.add(employee);
        return ResponseEntity.status(200).body("Employee add!");
    }
@PutMapping("/update/{index}")
    public ResponseEntity updateEmployee(@PathVariable int index, @Valid @RequestBody Employee employee, Errors errors)
    {
        if(errors.hasErrors())
        {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        employees.set(index,employee);
        return ResponseEntity.status(200).body("Employee updated!");
    }
@DeleteMapping("/delete/{index}")
    public ResponseEntity deleteEmployee(@PathVariable int index)
    {
        employees.remove(index);
        return ResponseEntity.status(200).body("Employee deleted!");
    }
@PutMapping("/annual/{index}")
    public ResponseEntity annualLeave(@PathVariable int index,@Valid @RequestBody int number,Errors errors)
    {
        if(errors.hasErrors())
        {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        Employee employee1 = employees.get(index);
        if(number <= employee1.getAnnualLeave())
        {
            int newNumber = employee1.getAnnualLeave() - number;
            employee1.setAnnualLeave(newNumber);
            return ResponseEntity.status(200).body("It's ok :)\nThe new annualLeave is " + employee1.getAnnualLeave());
        }
        else
            return
                    ResponseEntity.status(200).body("Sorry you cannot go :(");
    }
}
