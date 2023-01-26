package com.example.spring_day4_exc.pojo;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

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
    @Pattern(regexp = "[0-9]+", message = "Most be add numbers only!")
    @Min(value = 25,message = "Most be more than 25 years!")
    private String  age;
    @NotEmpty(message = "Most be not empty!")
    @Pattern(regexp = "(?:^|\\W)supervisor(?:$|\\W)|(?:^|\\W)coordinator(?:$|\\W)",message = "Please enter one of following words only (supervisor,coordinator)!")
    private String role;
    @AssertFalse(message = "most be false only!")
    private boolean onLeave;
    @NotNull(message = "Most be not empty!")

    @Min(value = 1990,message = "Most be more than 1990 years!")
    @Max(value = 2023,message = "Most be less than 2023 years!")
    @Pattern(regexp = "[0-9]+", message = "Most be add numbers only!")
    private String  employmentYear;
    @NotNull(message = "Most be not empty!")
    @Min(value = 1,message = "Most be more than 0 days!")
    @Pattern(regexp = "[0-9]+", message = "Most be add numbers only!")
    private String  annualLeave;
}
