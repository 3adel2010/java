package com.example.spring_day5_ecs.controllers;

import com.example.spring_day5_ecs.pojo.MerchantStock;
import com.example.spring_day5_ecs.service.MerchantStockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/merchantStock")
public class MerchantStockController
{
    private final MerchantStockService merchantStockService;

    @GetMapping("/get")
    public ArrayList<MerchantStock> getMerchantStock()
    {
        ArrayList<MerchantStock> merchantStock = merchantStockService.getMerchantStock();
        return merchantStock;
    }

    @PostMapping("/add")
    public ResponseEntity addMerchantStock(@Valid @RequestBody MerchantStock merchantStock, Errors errors)
    {
        if(errors.hasFieldErrors())
        {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantStockService.addMerchantStock(merchantStock);
        return ResponseEntity.status(200).body("Merchant stock added!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchantStock(@PathVariable int id,@Valid @RequestBody MerchantStock merchantStock,Errors errors)
    {
        if(errors.hasFieldErrors())
        {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdate = merchantStockService.updateMerchantStock(id, merchantStock);
        if(isUpdate)
        {
            return ResponseEntity.status(200).body("Merchant stock update!");
        }
        return ResponseEntity.status(400).body("Wrong ID!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchantStock(@PathVariable int id)
    {
        boolean isDeleted = merchantStockService.deleteMerchantStock(id);
        if(isDeleted)
        {
            return ResponseEntity.status(200).body("Merchant stock deleted!");
        }
        return ResponseEntity.status(400).body("Wrong ID!");
    }
}

