package com.example.spring_day5_ecs.controllers;

import com.example.spring_day5_ecs.pojo.Category;
import com.example.spring_day5_ecs.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController
{
    private final CategoryService categoryService;

    @GetMapping("/get")
    public ArrayList<Category> getCategory()
    {
        ArrayList<Category> categorie = categoryService.getCategory();
        return categorie;
    }

    @PostMapping("/add")
    private ResponseEntity addCategory(@Valid @RequestBody Category category, Errors errors)
    {
        if(errors.hasFieldErrors())
        {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        categoryService.addCategory(category);
        return ResponseEntity.status(200).body("Category added!");
    }

    @PutMapping("/update/{id}")
    private ResponseEntity updateCategory(@PathVariable int id,@Valid @RequestBody Category category,Errors errors)
    {
        if(errors.hasFieldErrors())
        {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = categoryService.updateCategory(id, category);
        if(isUpdated)
        {
            return ResponseEntity.status(200).body("Category updated!");
        }
        return ResponseEntity.status(400).body("Wrong ID!");
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity deleteCategory(@PathVariable int id)
    {
        boolean isDeleted = categoryService.deleteCategory(id);
        if(isDeleted)
        {
            return ResponseEntity.status(200).body("Category deleted!");
        }
        return ResponseEntity.status(400).body("Wrong ID!");
    }
}
