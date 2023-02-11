package com.example.spring_week5_day5_pro.Service;

import com.example.spring_week5_day5_pro.ApiException.ApiException;
import com.example.spring_week5_day5_pro.DTO.StoreDTO;
import com.example.spring_week5_day5_pro.Model.Location;
import com.example.spring_week5_day5_pro.Model.Store;
import com.example.spring_week5_day5_pro.Repository.LocationRepository;
import com.example.spring_week5_day5_pro.Repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService
{
    private final LocationRepository locationRepository;
    private  final StoreRepository storeRepository;
    public List<Location> getLocation()
    {
        return locationRepository.findAll();
    }
    public void addLocation(Location location)
    {
        locationRepository.save(location);
    }
    public boolean updateLocation(Integer id,Location location)
    {
        Location location1=locationRepository.findLocationById(id);
        if(location1==null)
            return false;
        location.setId(id);
        locationRepository.save(location);
        return true;
    }
    public boolean deleteLocation(Integer id)
    {
        Location location = locationRepository.findLocationById(id);
        if(location==null)
            return false;
        locationRepository.delete(location);
        return true;
    }
    public void addStoreDTO(StoreDTO storeDTO)
    {
        Store store = storeRepository.findStoreById(storeDTO.getStore_id());
        if(store==null)
            throw new ApiException("Wrong Id!");
        Location location = new Location(null,storeDTO.getArea(),storeDTO.getStreet(),store);
        locationRepository.save(location);
    }
    public void updateStoreDTO(StoreDTO storeDTO)
    {
        Location location = locationRepository.findLocationById(storeDTO.getStore_id());
        if(location==null)
            throw new ApiException("Wrong Id!");
    }
    public void deleteStoreDTO(Integer id)
    {
        Location location = locationRepository.findLocationById(id);
        if(location==null)
            throw new ApiException("Wrong Id!");
        locationRepository.delete(location.getStore().getLocation());
    }
}
