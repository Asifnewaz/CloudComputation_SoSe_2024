package com.asif.cc_summer.controllers;

import com.asif.cc_summer.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/category")
public class CategoryController {
    private final CategoryService categoryService;
}
