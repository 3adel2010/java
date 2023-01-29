package com.example.spring_day5_ecs.pojo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MerchantStock
{
    @NotNull(message = "ID most be not null!")
    @Min(value = 3,message = "ID most be more than 3 characters!")
    private int id;
    @NotEmpty(message = "Product ID most be not empty!")
    @Size(min = 3,message = "Product ID most be more than 3 characters!")
    private String productId;
    @NotEmpty(message = "Merchant ID most be not empty!")
    @Size(min = 3,message = "Merchant ID most be more than 3 characters!")
    private String merchantId;
    @NotEmpty(message = "Stock most be not empty!")
    @Size(min = 10,message = "Stock most be more than 10 characters!")
    private String stock;
}
