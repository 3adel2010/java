package com.example.spring_week6_day3.controller;

import com.example.spring_week6_day3.apiException.ApiException;
import com.example.spring_week6_day3.dto.MyDTO;
import com.example.spring_week6_day3.model.Orders;
import com.example.spring_week6_day3.model.User;
import com.example.spring_week6_day3.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController
{
    private final OrderService orderService;
    @GetMapping("/get")
    public ResponseEntity getOrder(@AuthenticationPrincipal User user)
    {
        List<Orders> orderList = orderService.getOrder(user);
        return ResponseEntity.status(HttpStatus.OK).body(orderList);
    }
    @PostMapping("/add")
    public ResponseEntity addOrder(@AuthenticationPrincipal User user, @RequestBody MyDTO myDTO)
    {
        orderService.addOrder(user, myDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Order added !");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateOrder(@AuthenticationPrincipal User user, @PathVariable Integer id,@RequestBody @Valid Orders order)
    {
        orderService.updateOrder(user, id, order);
        return ResponseEntity.status(HttpStatus.OK).body("Order updated !");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteOrder(@AuthenticationPrincipal User user, @PathVariable Integer id)
    {
        orderService.deleteOrder(user, id);
        return ResponseEntity.status(HttpStatus.OK).body("Order deleted !");
    }

    @PutMapping("/assign/{orderId}/user/{userId}")
    public ResponseEntity assignUserWithOrders(@PathVariable Integer userId,@PathVariable Integer orderId)
    {
        orderService.assignUserWithOrders(userId,orderId);
        return ResponseEntity.status(HttpStatus.OK).body("User assigned with orders !");
    }

    @PutMapping("/assign/{orderId}/product/{productId}")
    public ResponseEntity assignProductWithOrders(@PathVariable Integer productId,@PathVariable Integer orderId)
    {
        orderService.assignProductWithOrders(productId,orderId);
        return ResponseEntity.status(HttpStatus.OK).body("Product assigned with orders !");
    }
    @PutMapping("admin/{orderId}")
    public ResponseEntity<ApiException> updateOrderStatus(@PathVariable Integer orderId, @RequestBody Orders order){
        orderService.changeStatus(orderId,order.getStatus());
        return ResponseEntity.status(HttpStatus.OK).body(new ApiException("Order updated !"));
    }
    @GetMapping("{orderId}")
    public ResponseEntity <Orders> getOrderById(@AuthenticationPrincipal User user, @PathVariable Integer orderId){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrderById(user,orderId));
    }
}
