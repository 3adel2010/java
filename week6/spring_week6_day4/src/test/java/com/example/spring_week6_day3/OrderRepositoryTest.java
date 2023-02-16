package com.example.spring_week6_day3;

import com.example.spring_week6_day3.model.Orders;
import com.example.spring_week6_day3.model.Product;
import com.example.spring_week6_day3.model.User;
import com.example.spring_week6_day3.repository.OrderRepository;
import com.example.spring_week6_day3.repository.ProductRepository;
import com.example.spring_week6_day3.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OrderRepositoryTest
{
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;

    Orders orders1,orders2,orders3;
    User user;
    Product product;
    @BeforeEach
    void setUp()
    {
        Integer price = 1;
        Integer quantity = 50;
        Integer totalPrice = price * quantity;
        user = new User(null,"adel","123456","Admin",null);
        userRepository.save(user);
        product = new Product(null,"water",price,null);
        productRepository.save(product);
        orders1 = new Orders(null,quantity,totalPrice,new Date(),"new",user,product);
        orders2 = new Orders(null,quantity,totalPrice,new Date(),"new",user,product);
        orders3 = new Orders(null,quantity,totalPrice,new Date(),"new",user,product);
    }
    @Test
    public void findOrderById()
    {
        orderRepository.save(orders1);
        Orders orders = orderRepository.findOrderById(orders1.getId());
        Assertions.assertThat(orders).isEqualTo(orders1);
    }
    @Test
    public void getMyProducts()
    {
        orderRepository.save(orders1);
        orderRepository.save(orders2);
        orderRepository.save(orders3);
        List<Orders> ordersList = orderRepository.getMyProducts(product.getId());
        Assertions.assertThat(ordersList.get(0).getProduct().getId()).isEqualTo(product.getId());
    }
}
