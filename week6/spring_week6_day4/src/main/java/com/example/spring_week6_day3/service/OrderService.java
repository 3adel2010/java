package com.example.spring_week6_day3.service;

import com.example.spring_week6_day3.apiException.ApiException;
import com.example.spring_week6_day3.dto.MyDTO;
import com.example.spring_week6_day3.model.Orders;
import com.example.spring_week6_day3.model.Product;
import com.example.spring_week6_day3.model.User;
import com.example.spring_week6_day3.repository.OrderRepository;
import com.example.spring_week6_day3.repository.ProductRepository;
import com.example.spring_week6_day3.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService
{
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public List<Orders> getOrder(User user)
    {
        List orders = orderRepository.getMyProducts(user.getId());
        if(orders.isEmpty())
            throw new ApiException("This order is empty !");
        return orders;
    }
    public void addOrder(User user, MyDTO myDTO)
    {
        if(myDTO.getProductIds().size() != myDTO.getQuantities().size()){
            throw new ApiException("You did sometihng wrong!");
        }
        List<Product> products = productRepository.findAllById(myDTO.getProductIds());
        if(products.contains(null)){
            throw new ApiException("One of products not found");
        }
        if(products == null){
            throw new ApiException("Products not found");
        }
        Integer totalPrice=0;
        Integer quantities = 0;
        for (int i=0 ; i<myDTO.getQuantities().size(); i++){
            totalPrice += products.get(i).getPrice() * myDTO.getQuantities().get(i);
            quantities+= myDTO.getQuantities().get(i);
        }
        Orders order = new Orders();
        order.setTotalPrice(totalPrice);
        order.setQuantity(quantities);
        order.setProduct((Product) products);
        order.setStatus("new");
        order.setDateReceived(new Date());
        order.setUser(user);
        orderRepository.save(order);
    }
    public boolean updateOrder(User user, Integer id, Orders order)
    {
        Orders order1 = orderRepository.findOrderById(id);
        if(order1==null||order1.getUser().getId()!=user.getId())
            return false;
        order.setUser(user);
        order.setId(id);
        orderRepository.save(order);
        return true;
    }
    public boolean deleteOrder(User user, Integer id)
    {
        Orders order = orderRepository.findOrderById(id);
        if(order==null||order.getUser().getId()!=user.getId())
            return false;
        if(order.getStatus().equals("inProgress")||order.getStatus().equals("completed"))
            throw new ApiException("You can't delete it !");
        orderRepository.delete(order);
        return true;
    }
    public void assignUserWithOrders(Integer userId,Integer orderId)
    {
        User user = userRepository.findUsersById(userId);
        Orders orders = orderRepository.findOrderById(orderId);
        if(user==null||orders==null)
            throw new ApiException("Wrong Id !");
        user.getOrders().add(orders);
        userRepository.save(user);
    }

    public void assignProductWithOrders(Integer productId,Integer orderId)
    {
        Product product = productRepository.findProductById(productId);
        Orders orders = orderRepository.findOrderById(orderId);
        if (product == null || orders == null)
            throw new ApiException("Wrong Id !");
        product.getOrders().add(orders);
        productRepository.save(product);
    }

    public void changeStatus(Integer orderId, String status)
    {
        Orders oldOrder = orderRepository.findById(orderId).get();
        if (!status.equals("new") && !status.equals("inProgress") && !status.equals("completed"))
        {
            throw new ApiException("Status must be new, inProgress or completed only !");
        }
        oldOrder.setStatus(status);
        orderRepository.save(oldOrder);
    }

    public Orders getOrderById(User user, Integer orderId)
    {
        Orders order = orderRepository.findById(orderId).get();
        if (order == null)
        {
            throw new ApiException("Wrong order !");
        }
        if (order.getUser().getId() != user.getId())
        {
            throw new ApiException("You don't own that !");
        }
        return order;
    }
}
