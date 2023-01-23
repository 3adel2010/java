package com.example.spring_day_02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class welcomeController
{
    @GetMapping("/name")
    public String getName()
    {
        return "My name is adel";
    }
    @GetMapping("/age")
    public String  getAge()
    {
        return "My age is 36";
    }
    @GetMapping("check/status")

    public String getStatus()
    {
        return "Everything OK";
    }
    @GetMapping("/health")
    public String getHealth()
    {
        return "Server health is up and running";
    }
}
