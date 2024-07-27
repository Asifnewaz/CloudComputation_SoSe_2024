package com.asif.cc_summer.controllers;

import com.asif.cc_summer.dto.request.ProductDto;
import com.asif.cc_summer.dto.response.BaseResponseDto;
import com.asif.cc_summer.entity.Product;
import com.asif.cc_summer.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveProduct(@RequestParam ProductDto product) {
        Product obj = productService.saveProduct(product);

        BaseResponseDto response = new BaseResponseDto();
        response.statusCode = 200;
        response.success_message = "Category added successfully";
        response.data = obj;
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/productWithID", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> productWithID(@RequestParam Integer productID) {

        Product obj = productService.getProductById(Long.valueOf(productID));
        BaseResponseDto response = new BaseResponseDto();
        response.statusCode = 200;
        response.success_message = "Category added successfully";
        response.data = obj;

        return ResponseEntity.ok(response);
    }

    //get product
    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProduct() {
        List<Product> products = productService.getAllProducts();
        BaseResponseDto response = new BaseResponseDto();
        response.statusCode = 200;
        response.success_message = "Category added successfully";
        response.data = products;
        return ResponseEntity.ok(response);
    }


}
