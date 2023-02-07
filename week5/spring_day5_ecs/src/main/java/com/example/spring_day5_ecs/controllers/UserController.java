package com.example.spring_day5_ecs.controllers;

import com.example.spring_day5_ecs.pojo.Product;
import com.example.spring_day5_ecs.pojo.User;
import com.example.spring_day5_ecs.service.MerchantService;
import com.example.spring_day5_ecs.service.MerchantStockService;
import com.example.spring_day5_ecs.service.ProductService;
import com.example.spring_day5_ecs.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController
{
    private final UserService userService;
    private final MerchantStockService merchantStockService;
    private final ProductService productService;

    @GetMapping("/get")
    public ArrayList<User> getUser()
    {
        ArrayList<User> user = userService.getUser();
        return user;
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors errors)
    {
        if(errors.hasFieldErrors())
        {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("User Added!");
    }
@PostMapping("/addProduct")
    public ResponseEntity addProductFromUser(int productID,String merchantID,String stock)
    {
        int merchantIndex = merchantStockService.toCheck(merchantID);
        int productIndex = productService.toCheck(productID);
        if (merchantIndex < 0)
        {
            return ResponseEntity.status(400).body("Merchant not found!");
        }
        if (productIndex < 0)
        {
            return ResponseEntity.status(400).body("Product not found!");
        }
        merchantStockService.addMerchantStock(productID,merchantID,stock);
        return ResponseEntity.status(200).body("Product successfully!");
    }
@PutMapping("/buy")
    public ResponseEntity buyProductFromUser(int userID,String  productID,String merchantID)
    {
        int userId = userService.getUser().get(userID).getId();
        User user = getUser().get(userId);
        int productId = productService.getProduct().get(Integer.parseInt(productID)).getId();
        Product product = productService.getProduct().get(productId);

        int merchantIndex = merchantStockService.toCheck(merchantID);
        int productIndex = productService.toCheck(Integer.parseInt(productID));
        boolean ifFound = merchantStockService.searching(productID,merchantID);

        if(merchantIndex < 0){
            return ResponseEntity.status(404).body("Merchant not found!");
        }
        if(productIndex < 0){
            return ResponseEntity.status(404).body("Product not found!");
        }
        if(!ifFound)
        {
            return ResponseEntity.status(404).body("Merchant stock not found!");
        }
        if(user.getBalance() < product.getPrice())
        {
            return ResponseEntity.status(400).body("Your balance is less than order!");
        }
        user.setBalance(user.getBalance() - product.getPrice());
        return ResponseEntity.status(200).body("The purchase was completed successfully!");

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable int id,@Valid @RequestBody User user,Errors errors)
    {
        if(errors.hasFieldErrors())
        {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdate = userService.updateUser(id,user);
        if(isUpdate)
        {
            return ResponseEntity.status(200).body("User updated!");
        }
        return ResponseEntity.status(400).body("Wrong ID!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable int id)
    {
        boolean isDeleted = userService.deleteUser(id);
        if(isDeleted)
        {
            return ResponseEntity.status(200).body("User deleted!");
        }
        return ResponseEntity.status(400).body("Wrong ID!");
    }
}

