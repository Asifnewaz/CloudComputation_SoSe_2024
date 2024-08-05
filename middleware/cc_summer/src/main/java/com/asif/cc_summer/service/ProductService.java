package com.asif.cc_summer.service;

import com.asif.cc_summer.dto.request.ProductDto;
import com.asif.cc_summer.entity.Product;
import com.asif.cc_summer.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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

    public Product saveProduct(String  name,
                               String  prod_description,
                               Double  price,
                               String  image,
                               Long pro_Category,
                               Integer availalbe) {
        Product obj = new Product();
        obj.setName(name);
        obj.setPrice(price);
        obj.setFull_description(prod_description);
        obj.setAvailable_product(availalbe);
        obj.setImage(image);
        obj.setCategory_id(pro_Category);
        return productRepository.save(obj);
    }
}
