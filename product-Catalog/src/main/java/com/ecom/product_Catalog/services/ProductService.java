package com.ecom.product_Catalog.services;

import com.ecom.product_Catalog.model.Product;
import com.ecom.product_Catalog.repositories.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public List<Product> findByCategoryId(Long categoryId){
        return productRepo.findByCategoryId(categoryId);
    }
}
