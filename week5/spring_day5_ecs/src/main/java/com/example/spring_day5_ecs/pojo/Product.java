package com.example.spring_day5_ecs.pojo;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class Product
{
    @NotNull(message = "ID most be not null!")
    @Min(value = 3,message = "ID most be more than 3 characters!")
    private int id;
    @NotEmpty(message = "Name most be not empty!")
    @Size(min = 3,message = "Name most be more than 3 characters!")
    private String name;
    @NotNull(message = "Price most be not null!")
    @Positive(message = "Price most be positive number!")
    private int price;
    @NotEmpty(message = "Category most be not empty!")
    @Size(min = 3,message = "Category most be more than 3 characters!")
    private String categoryId;
}
