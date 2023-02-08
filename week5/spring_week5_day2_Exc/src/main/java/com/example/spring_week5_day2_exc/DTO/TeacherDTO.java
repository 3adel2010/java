package com.example.spring_week5_day2_exc.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeacherDTO
{
    private Integer teacher_Id;
    private String street;
    private Integer buildingNumber;
}
