package com.asif.cc_summer.controllers;

import com.asif.cc_summer.dto.response.BaseResponseDto;
import com.asif.cc_summer.entity.ProductCategory;
import com.asif.cc_summer.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/category")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping(value ="/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addCategory(@RequestParam String categoryName,@RequestParam String categoryImage) {
        ProductCategory category = categoryService.addService(categoryName, categoryImage);

        BaseResponseDto response = new BaseResponseDto();
        response.statusCode = 200;
        response.success_message = "Category added successfully";
        response.data = category;
        return ResponseEntity.ok(response);
    }


    @GetMapping(value ="/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCategory() {
        List<ProductCategory> list = categoryService.getAllCategory();

        BaseResponseDto response = new BaseResponseDto();
        response.statusCode = 200;
        response.success_message = "";
        response.data = list;
        return ResponseEntity.ok(response);
    }


}
