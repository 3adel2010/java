package com.example.spring_week6_day3.controller;

import com.example.spring_week6_day3.model.Product;
import com.example.spring_week6_day3.model.User;
import com.example.spring_week6_day3.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController
{
    private final ProductService productService;
    @GetMapping("/get")
    public ResponseEntity getProduct(@AuthenticationPrincipal User user)
    {
        List<Product> productList = productService.getProduct(user);
        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }
    @PostMapping("/add")
    public ResponseEntity addProduct(@AuthenticationPrincipal User user, @RequestBody @Valid Product product)
    {
        productService.addProduct(user, product);
        return ResponseEntity.status(HttpStatus.OK).body("Product added !");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@AuthenticationPrincipal User user, @PathVariable Integer id,@RequestBody @Valid Product product)
    {
        productService.updateProduct(user, id, product);
        return ResponseEntity.status(HttpStatus.OK).body("Product updated !");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@AuthenticationPrincipal User user, @PathVariable Integer id)
    {
        productService.deleteProduct(user, id);
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted !");
    }
    @GetMapping("{id}")
    public ResponseEntity<Product> addProduct(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductById(id));
    }
}
