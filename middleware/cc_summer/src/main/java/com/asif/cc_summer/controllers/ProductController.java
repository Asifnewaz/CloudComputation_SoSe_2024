package com.asif.cc_summer.controllers;

import com.asif.cc_summer.dto.request.ProductDto;
import com.asif.cc_summer.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/product")
public class ProductController {
    private final ProductService productService;


    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveProduct(@RequestBody ProductDto product) {
        return ResponseEntity.ok(productService.saveProduct(product));
    }

    //get product
    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProduct() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

}
