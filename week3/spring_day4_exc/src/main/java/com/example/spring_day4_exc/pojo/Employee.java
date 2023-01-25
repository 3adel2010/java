package com.example.spring_day4_exc.pojo;

import jakarta.validation.constraints.*;
import jdk.jfr.BooleanFlag;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Primary;
import org.springframework.format.annotation.NumberFormat;

@Data
@AllArgsConstructor
public class Employee
{
    @NotEmpty(message = "Most be not empty!")
    @Size(min = 2, message = "Most be more than 2 digits!")
    private String id;
    @NotEmpty(message = "Most be not empty!")
    @Size(min = 4, message = "Most be more than 2 digits!")
    private String name;
    @NotNull(message = "Most be not empty!")
    //@Pattern(regexp = "^[0-9]+$",message = "Most be more add numbers only!")
    @Min(value = 25,message = "Most be more than 25 years!")
    private int age;
    @NotEmpty(message = "Most be not empty!")
    @Pattern(regexp = "(?:^|\\W)supervisor(?:$|\\W)|(?:^|\\W)coordinator(?:$|\\W)")
    private String role;
    @AssertFalse(message = "most be false only!")
    private boolean onLeave;
    @NotNull(message = "Most be not empty!")

    @Min(value = 1990,message = "Most be more than 1990 years!")
    @Max(value = 2023,message = "Most be less than 2023 years!")
    private int employmentYear;
    @NotNull(message = "Most be not empty!")
    @Min(value = 0,message = "Most be more than 0 days!")
    private int annualLeave;
}
