package com.bridgelabz.aop1.repository;

import com.bridgelabz.aop1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer>
{

}
