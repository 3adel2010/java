package com.example.spring_day5_ecs.pojo;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User
{
    @NotNull(message = "ID most be not null!")
    @Min(value = 3,message = "ID most be more than 3 characters!")
    private int id;
    @NotEmpty(message = "User name most be not empty!")
    @Size(min = 5,max = 20,message = "User name most be more than 5 characters!")
    private String userName;
    @NotEmpty(message = "Password most be not empty!")
    @Size(min = 6, max = 35,message = "Password most be more than 6 characters!")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$",message = "Password should be more than 8 digits contains letters, numbers and symbols!")
    private String password;
    @NotEmpty(message = "Email most be not empty!")
    @Email(message = "Wrong email!")
    private String email;
    @NotEmpty(message = "Role most be not empty!")
    @Pattern(regexp = "(?:^|\\W)Admin(?:$|\\W)|(?:^|\\W)Customer(?:$|\\W)",
            message = "Wrong role!, Please enter one of following words only (Admin,Customer)!")
    private String role;
    @NotNull(message = "Balance most be not null!")
    @Positive(message = "Balance most be positive number!")
    private int balance;
}
