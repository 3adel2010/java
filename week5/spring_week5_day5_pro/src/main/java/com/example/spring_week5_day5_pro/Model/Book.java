package com.example.spring_week5_day5_pro.Model;

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
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Name should be not empty!")
    @Size(min = 3,message = "Name most be more than 1 character!")
    private String name;
    @NotNull(message = "Book count should be not empty!")
    private Integer bookCount;
    @NotEmpty(message = "Genre should be not empty!")
    @Size(min = 3,message = "Genre most be more than 3 character!")
    private String genre;

    @ManyToOne
    @JoinColumn(name = "store_id",referencedColumnName = "id")
    @JsonIgnore
    private Store store;
}
