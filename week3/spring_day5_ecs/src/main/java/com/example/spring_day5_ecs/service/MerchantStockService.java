package com.example.spring_day5_ecs.service;

import com.example.spring_day5_ecs.pojo.MerchantStock;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantStockService
{
    ArrayList<MerchantStock> merchantStocks = new ArrayList<>();

    public ArrayList<MerchantStock> getMerchantStock()
    {
        return merchantStocks;
    }

    public void addMerchantStock(MerchantStock merchantStock)
    {
        merchantStocks.add(merchantStock);
    }

    public boolean updateMerchantStock(int id, MerchantStock merchantStock)
    {
        for (int i = 0; i < merchantStocks.size(); i++)
        {
            if(merchantStocks.get(i).getId() == id)
            {
                merchantStocks.set(i,merchantStock);
                return true;
            }
        }
        return false;
    }

    public boolean deleteMerchantStock(int id)
    {
        for (int i = 0; i < merchantStocks.size(); i++)
        {
            if(merchantStocks.get(i).getId() == id)
            {
                merchantStocks.remove(i);
                return true;
            }
        }
        return false;
    }

    public int toCheck(String merchantID)
    {
        for (int i = 0; i < merchantStocks.size(); i++)
        {
            if (merchantStocks.get(i).getProductId() == merchantID)
            {
                return i;
            }
        }
        return -1;
    }

    public void addMerchantStock(int productID, String merchantID, String stock)
    {
        int index = -1;
        for (int i = 0; i < merchantStocks.size(); i++)
        {
            index++;
        }
        String theProduct = String.valueOf(productID);
        MerchantStock merchantStock1 = new MerchantStock(index,theProduct,merchantID,stock);
        merchantStocks.add(merchantStock1);
    }

    public boolean searching(String  productID,String merchantID)
    {
        for (int i = 0; i < merchantStocks.size(); i++)
        {
            if(merchantStocks.get(i).getProductId() == productID && merchantStocks.get(i).getMerchantId() == merchantID)
            {
                return true;
            }
        }
        return false;
    }
}
