package com.example.spring_week5_day5_pro.ApiException;

import org.springframework.web.bind.annotation.RestControllerAdvice;


public class ApiException extends RuntimeException
{
    public ApiException(String message)
    {
        super(message);
    }
}
