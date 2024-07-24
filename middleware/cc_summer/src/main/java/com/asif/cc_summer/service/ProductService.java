package com.asif.cc_summer.service;

import com.asif.cc_summer.dto.request.ProductDto;
import com.asif.cc_summer.entity.Product;
import com.asif.cc_summer.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product saveProduct(ProductDto productDto) {
        Product obj = new Product();
        obj.setName(productDto.getName());
        obj.setPrice(productDto.getPrice());
        obj.setFull_description(productDto.getProductDescription());

        return productRepository.save(obj);
    }
}
