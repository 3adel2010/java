package com.example.spring_week5_day5_pro.Controller;

import com.example.spring_week5_day5_pro.DTO.StoreDTO;
import com.example.spring_week5_day5_pro.Model.Location;
import com.example.spring_week5_day5_pro.Service.LocationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.interfaces.RSAPrivateCrtKey;
import java.util.List;

@RestController
@RequestMapping("/api/v1/location")
@RequiredArgsConstructor
public class LocationController
{
    private final LocationService locationService;
    @GetMapping("/get")
    public ResponseEntity getLocation()
    {
        List<Location> locationList = locationService.getLocation();
        return ResponseEntity.status(200).body(locationList);
    }
    @PostMapping("/add")
    public ResponseEntity addLocation(@Valid @RequestBody Location location)
    {
        locationService.addLocation(location);
        return ResponseEntity.status(200).body("Location added!");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateLocation(@PathVariable Integer id,@Valid @RequestBody Location location)
    {
        locationService.updateLocation(id, location);
        return ResponseEntity.status(200).body("Location updated!");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteLocation(@PathVariable Integer id)
    {
        locationService.deleteLocation(id);
        return ResponseEntity.status(200).body("Location deleted!");
    }
    @PostMapping("/addDTO")
    public ResponseEntity addDTO(@Valid @RequestBody StoreDTO storeDTO)
    {
        locationService.addStoreDTO(storeDTO);
        return ResponseEntity.status(200).body("Store DTO added!");
    }
    @PutMapping("/updateDTO")
    public ResponseEntity updateDTO(@Valid @RequestBody StoreDTO storeDTO)
    {
        locationService.updateStoreDTO(storeDTO);
        return ResponseEntity.status(200).body("Store DTO updated!");
    }
    @DeleteMapping("/deleteDTO/{id}")
    public ResponseEntity deleteDTO(@PathVariable Integer id)
    {
        locationService.deleteStoreDTO(id);
        return ResponseEntity.status(200).body("Store DTO deleted!");
    }
}
