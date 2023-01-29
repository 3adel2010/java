package com.example.spring_day5_ecs.service;

import com.example.spring_day5_ecs.controllers.ProductController;
import com.example.spring_day5_ecs.pojo.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService
{
    ArrayList<Product> products = new ArrayList<Product>();

    public ArrayList<Product> getProduct()
    {
        return products;
    }

    public void addProduct(Product product)
    {
        products.add(product);
    }

    public boolean updateProduct(int id, Product product)
    {
        for (int i = 0; i < products.size(); i++)
        {
            if(products.get(i).getId() == id)
            {
                products.set(i,product);
                return true;
            }
        }
        return false;
    }

    public boolean deleteProduct(int id)
    {
        for (int i = 0; i < products.size(); i++)
        {
            if(products.get(i).getId() == id)
            {
                products.remove(i);
                return true;
            }
        }
        return false;
    }

    public int toCheck(int productID)
    {
        for (int i = 0; i < products.size(); i++)
        {
            if (products.get(i).getId() == productID)
            {
                return i;
            }
        }
        return -1;
    }
}
