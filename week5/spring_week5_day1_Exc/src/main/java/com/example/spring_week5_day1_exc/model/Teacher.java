package com.example.spring_week5_day1_exc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Name should be not empty!")
    @Size(min = 3,message = "Name most be more than 1 character!")
    private String name;
    @NotNull(message = "Age can't be null!")
    @Min(value = 6,message = "Age should be more than 6 years old!")
    @Max(value = 65,message = "Age should be less than 65 years old!")
    private Integer age;
    @NotEmpty(message = "Email should be not empty!")
    @Email(message = "This is wrong email")
    private String email;
    @NotNull(message = "Salary can't be null!")
    private Integer salary;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;
}
