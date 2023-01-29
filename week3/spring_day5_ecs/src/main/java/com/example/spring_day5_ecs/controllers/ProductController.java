package com.example.spring_day5_ecs.controllers;

import com.example.spring_day5_ecs.pojo.Product;
import com.example.spring_day5_ecs.service.MerchantService;
import com.example.spring_day5_ecs.service.MerchantStockService;
import com.example.spring_day5_ecs.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController
{
    private final ProductService productService;

    @GetMapping("/get")
    public ArrayList<Product> getProduct()
    {
        ArrayList<Product> product = productService.getProduct();
        return product;
    }

    @PostMapping("/add")
    public ResponseEntity addProduct(@Valid @RequestBody Product product, Errors errors)
    {
        if(errors.hasFieldErrors())
        {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        productService.addProduct(product);
        return ResponseEntity.status(200).body("Product added!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@PathVariable int id,@Valid @RequestBody Product product,Errors errors)
    {
        if(errors.hasFieldErrors())
        {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = productService.updateProduct(id, product);
        if (isUpdated)
        {
            return ResponseEntity.status(200).body("Product updated!");
        }
        return ResponseEntity.status(400).body("Wrong ID!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable int id)
    {
        boolean isDeleted = productService.deleteProduct(id);
        if (isDeleted)
        {
            return ResponseEntity.status(200).body("Product deleted!");
        }
        return ResponseEntity.status(400).body("Wrong ID!");
    }
}
