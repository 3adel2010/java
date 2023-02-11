package com.example.spring_week5_day5_pro.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Name should be not empty!")
    @Size(min = 3,message = "Name most be more than 1 character!")
    private String name;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "store")
    private Location location;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "store")
    private List<Book> book;

    @ManyToMany(mappedBy = "stores")
    private List<Customer> customers;
}
