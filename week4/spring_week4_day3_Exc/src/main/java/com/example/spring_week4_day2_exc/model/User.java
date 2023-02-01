package com.example.spring_week4_day2_exc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Name should be not empty!")
    @Column(columnDefinition = "varchar(15) not null")
    @Size(min = 4,message = "Name most be more than 4 characters!")
    private String name;
    @NotEmpty(message = "User name should be not empty!")
    @Column(columnDefinition = "varchar(30) not null unique")
    @Size(min = 4,message = "User name most be more than 4 characters!")
    private String userName;
    @NotEmpty(message = "Password should be not empty!")
    @Column(columnDefinition = "varchar(50) not null")
    private String password;
    @NotEmpty(message = "Email should be not empty!")
    @Column(columnDefinition = "varchar(50) not null unique")
    @Email(message = "This is wrong email!")
    private String email;
    @NotEmpty(message = "Role should be not empty!")
    @Column(columnDefinition = "varchar(25) not null")
    @Pattern(regexp = "(?:^|\\W)user(?:$|\\W)|(?:^|\\W)admin(?:$|\\W)")
    private String role;
    @NotNull(message = "Age should be not null!")
    @Column(columnDefinition = "Integer(25) not null")
    private Integer age;
}
