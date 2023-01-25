package com.example.spring_day_exc.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Bank
{
    private String id;
    private String userName;
    private double balance;
}
