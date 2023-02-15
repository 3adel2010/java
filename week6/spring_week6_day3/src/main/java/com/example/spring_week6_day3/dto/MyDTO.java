package com.example.spring_week6_day3.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
@Data
public class MyDTO
{
    @NotNull(message = "products ids must not be null")
    private List<Integer> productIds;
    @NotNull(message = "quantities must not be null")
    private List<Integer> quantities;
}
