package com.asif.cc_summer.controllers;

import com.asif.cc_summer.entity.ProductCategory;
import com.asif.cc_summer.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/category")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping(value ="/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addCategory(@RequestParam String categoryName,@RequestParam String categoryImage) {
        ProductCategory response = categoryService.addService(categoryName, categoryImage);
        return ResponseEntity.ok(response);
    }


}
