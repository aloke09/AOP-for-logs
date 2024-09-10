package com.bridgelabz.aop1.controller;

import com.bridgelabz.aop1.model.Product;
import com.bridgelabz.aop1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductCtrl
{
    @Autowired
    private ProductService service;

    @PostMapping("/insert")
    public Product insert(@RequestBody Product product)
    {
        return service.addProduct(product);
    }

    @GetMapping("/all")
    public List<Product> getAll()
    {
        return service.getAll();
    }
}
