package com.example.spring_week5_day1_exc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Area should be not empty!")
    @Size(min = 3,message = "Area most be more than 1 character!")
    private String area;
    @NotEmpty(message = "Street should be not empty!")
    @Size(min = 3,message = "Street most be more than 1 character!")
    private String street;
    @NotNull(message = "Building number can't be null!")
    private Integer buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
