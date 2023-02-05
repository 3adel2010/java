package com.example.spring_week4_day4_exc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Name can't be empty!")
    @Size(min = 2,message = "Name characters most be more than 2!")
    private String name;
    @NotEmpty(message = "Genre can't be empty1!")
    @Pattern(regexp = "(?:^|\\\\W)Drama(?:$|\\\\W)|(?:^|\\\\W)Action(?:$|\\\\W)|(?:^|\\\\W)Comedy(?:$|\\\\W)")
    private String genre;
    @NotNull(message = "rating can't be null!")
    @Min(value = 1,message = "Rating should be between 1 and 5 only!")
    @Max(value = 5,message = "Rating should be between 1 and 5 only!")
    private Integer rating;
    @NotNull(message = "Duration can't be null!")
    @Min(value = 60,message = "Duration most be more than 60!")
    private Integer duration;
    @NotNull(message = "Director id should be not null!")
    private Integer directorId;
}
