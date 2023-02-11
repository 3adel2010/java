package com.example.spring_week5_day2_exc.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.SecureRandom;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Name should be not empty!")
    @Size(min = 3,message = "Name most be more than 1 character!")
    private String name;
    @NotNull(message = "Age can't be null!")
    @Min(value = 6,message = "Age should be more than 6 years old!")
    @Max(value = 95,message = "Age should be less than 65 years old!")
    private Integer age;
    @NotEmpty(message = "Major should be not empty!")
    @Size(min = 2,message = "Major most be more than 2 character!")
    private String major;

    @ManyToMany(mappedBy = "student")
    private List<Course> course;
}
