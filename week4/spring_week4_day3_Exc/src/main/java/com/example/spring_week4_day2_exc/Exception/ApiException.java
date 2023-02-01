package com.example.spring_week4_day2_exc.Exception;

public class ApiException extends RuntimeException
{
    public ApiException(String message)
    {
        super(message);
    }
}
