package com.example.spring_week4_day4_exc.controller;

import com.example.spring_week4_day4_exc.model.Director;
import com.example.spring_week4_day4_exc.service.DirectorService;
import jakarta.persistence.Entity;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/director")
@RequiredArgsConstructor
public class DirectorController
{
    private final DirectorService directorService;
    @GetMapping("/get")
    public ResponseEntity getDirector()
    {
        List<Director> directors = directorService.getDirector();
        return ResponseEntity.status(200).body(directors);
    }
    @PostMapping("/add")
    public ResponseEntity addDirector(@Valid @RequestBody Director director)
    {
        directorService.addDirector(director);
        return ResponseEntity.status(200).body("Director Added!");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateDirector(@PathVariable Integer id,@Valid @RequestBody Director director)
    {
        directorService.updateDirector(id,director);
        return ResponseEntity.status(200).body("Director updated!");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDirector(@PathVariable Integer id)
    {
        directorService.deleteDirector(id);
        return ResponseEntity.status(200).body("Director deleted!");
    }
}
