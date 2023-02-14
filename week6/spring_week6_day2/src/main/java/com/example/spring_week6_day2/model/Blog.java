package com.example.spring_week6_day2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
public class Blog
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "title title be null")
    private String title;
    @NotEmpty(message = "body body be null")
    private String body;

    @ManyToOne
    @JoinColumn(name = "userId",referencedColumnName = "Id")
    @JsonIgnore
    private MyUser myUser;
}
