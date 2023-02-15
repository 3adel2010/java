package com.example.spring_week6_day3.service;

import com.example.spring_week6_day3.apiException.ApiException;
import com.example.spring_week6_day3.model.Product;
import com.example.spring_week6_day3.model.User;
import com.example.spring_week6_day3.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService
{
    private final ProductRepository productRepository;

    public List<Product> getProduct(User user)
    {
        List products =productRepository.getMyProducts(user.getId());
        if(products.isEmpty())
            throw new ApiException("This product is empty !");
        return products;
    }
    public void addProduct(User user, Product product)
    {
        product.setName(user.getUsername());
        productRepository.save(product);
    }
    public boolean updateProduct(User user, Integer id,Product product)
    {
        Product product1 = productRepository.findProductById(id);
        if(product1==null||product1.getId()!=user.getId())
            return false;
        product.setName(user.getUsername());
        product.setId(id);
        productRepository.save(product);
        return true;
    }
    public boolean deleteProduct(User user, Integer id)
    {
        Product product = productRepository.findProductById(id);
        if(product==null||product.getId()!= user.getId())
            return false;
        productRepository.delete(product);
        return true;
    }
    public Product getProductById(Integer productId) {
        Product product = productRepository.findProductById(productId);
        if(product==null){
            throw new ApiException("Product not found.");
        }
        return product;
    }
}
