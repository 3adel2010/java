package com.example.spring_week4_day4_exc.apiException;

public class ApiException extends RuntimeException
{
    public ApiException(String message)
    {
        super(message);
    }
}
