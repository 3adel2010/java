package com.example.spring_week5_day5_pro.Service;

import com.example.spring_week5_day5_pro.Model.Store;
import com.example.spring_week5_day5_pro.Repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService
{
    private final StoreRepository storeRepository;
    public List<Store> getStore()
    {
        return storeRepository.findAll();
    }
    public void addStore(Store store)
    {
        storeRepository.save(store);
    }
    public boolean updateStore(Integer id,Store store)
    {
        Store store1 = storeRepository.findStoreById(id);
        if(store1==null)
            return false;
        store.setId(id);
        storeRepository.save(store);
        return true;
    }
    public boolean deleteStore(Integer id)
    {
        Store store = storeRepository.findStoreById(id);
        if(store==null)
            return false;
        storeRepository.delete(store);
        return true;
    }
}
