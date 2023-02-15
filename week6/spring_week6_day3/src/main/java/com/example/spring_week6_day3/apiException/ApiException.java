package com.example.spring_week6_day3.apiException;

public class ApiException extends RuntimeException
{
    public ApiException(String message)
    {
        super(message);
    }
}
