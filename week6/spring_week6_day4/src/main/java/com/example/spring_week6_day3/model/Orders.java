package com.example.spring_week6_day3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Quantity can not be null")
    @Min(value = 0, message = "Quantity can not be negative!")
    private Integer quantity;
    @NotNull(message = "Total price can not be null")
    @Positive( message = "totalPrice must be positive!")
    private Integer totalPrice;
    @Column(columnDefinition = "TIMESTAMP not null")
    private Date dateReceived;
    @Column(columnDefinition = "varchar(12)  default 'new' check(status='new' or status='inProgress' or status='completed')")
    private String status;

    @ManyToOne
    @JoinColumn(name = "userId",referencedColumnName = "Id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "productId",referencedColumnName = "Id")
    @JsonIgnore
    private Product product;
}
