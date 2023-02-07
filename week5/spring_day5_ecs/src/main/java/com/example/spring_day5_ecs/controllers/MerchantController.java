package com.example.spring_day5_ecs.controllers;

import com.example.spring_day5_ecs.pojo.Merchant;
import com.example.spring_day5_ecs.service.MerchantService;
import com.example.spring_day5_ecs.service.MerchantStockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/merchant")
public class MerchantController
{
    private final MerchantService merchantService;

    @GetMapping("/get")
    public ArrayList<Merchant> getMerchant()
    {
        ArrayList<Merchant> merchant = merchantService.getMerchant();
        return merchant;
    }

    @PostMapping("/add")
    private ResponseEntity addMerchant(@Valid @RequestBody Merchant merchant, Errors errors)
    {
        if(errors.hasFieldErrors())
        {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantService.addMerchant(merchant);
        return ResponseEntity.status(200).body("Merchant Added!");
    }

    @PutMapping("/update/{id}")
    private ResponseEntity updateMerchant(@PathVariable int id,@Valid @RequestBody Merchant merchant,Errors errors)
    {
        if(errors.hasFieldErrors())
        {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = merchantService.updateMerchant(id, merchant);
        if(isUpdated)
        {
            return ResponseEntity.status(200).body("Merchant updated!");
        }
        return ResponseEntity.status(400).body("Wrong ID!");
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity deleteMerchant(@PathVariable int id)
    {
        boolean isDeleted = merchantService.deleteMerchant(id);
        if(isDeleted)
        {
            return ResponseEntity.status(200).body("Merchant deleted!");
        }
        return ResponseEntity.status(400).body("Wrong ID!");
    }
}
