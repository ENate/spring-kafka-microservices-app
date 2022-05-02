package com.minejava.productservice.service;

import com.minejava.productservice.dto.ProductRequest;
import com.minejava.productservice.model.Product;
import com.minejava.productservice.repository.ProductRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                          .name(productRequest.getName())
                          .description(productRequest.getDescription())
                          .price(productRequest.getPrice())
                          .build();
        
        // Finally save
        productRepository.save(product);
    }
}
