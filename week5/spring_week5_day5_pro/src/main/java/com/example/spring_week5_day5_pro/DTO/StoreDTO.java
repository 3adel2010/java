package com.example.spring_week5_day5_pro.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StoreDTO
{
    private Integer store_id;
    private String area;
    private String street;
}
