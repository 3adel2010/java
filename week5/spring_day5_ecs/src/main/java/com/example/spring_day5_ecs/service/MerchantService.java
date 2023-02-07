package com.example.spring_day5_ecs.service;

import com.example.spring_day5_ecs.pojo.Merchant;
import com.example.spring_day5_ecs.pojo.MerchantStock;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import java.util.ArrayList;

@Service
public class MerchantService
{
    ArrayList<Merchant> merchants = new ArrayList<>();

    public ArrayList<Merchant> getMerchant()
    {
        return merchants;
    }

    public void addMerchant(Merchant merchant)
    {
        merchants.add(merchant);
    }

    public boolean updateMerchant(int id, Merchant merchant)
    {
        for (int i = 0; i < merchants.size(); i++)
        {
            if(merchants.get(i).getId() == id)
            {
                merchants.set(i,merchant);
                return true;
            }
        }
        return false;
    }

    public boolean deleteMerchant(int id)
    {
        for (int i = 0; i < merchants.size(); i++)
        {
            if(merchants.get(i).getId() == id)
            {
                merchants.remove(i);
                return true;
            }
        }
        return false;
    }
}
