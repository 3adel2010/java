package com.example.spring_day5_ecs.pojo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Merchant
{
    @NotNull(message = "ID most be not null!")
    @Min(value = 3,message = "ID most be more than 3 characters!")
    private int id;
    @NotEmpty(message = "Name most be not empty!")
    @Size(min = 3,message = "Name most be more than 3 characters!")
    private String name;
}
