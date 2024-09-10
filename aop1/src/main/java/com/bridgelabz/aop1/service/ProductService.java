package com.bridgelabz.aop1.service;

import com.bridgelabz.aop1.model.Product;
import com.bridgelabz.aop1.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService
{
    @Autowired
    private ProductRepo repo;

    public Product addProduct(Product product)
    {
        return repo.save(product);
    }

    public List<Product> getAll()
    {
        return repo.findAll();
    }
}
