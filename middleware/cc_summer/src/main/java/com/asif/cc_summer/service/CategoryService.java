package com.asif.cc_summer.service;

import com.asif.cc_summer.entity.Category;
import com.asif.cc_summer.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;


   public Category addService(String categoryName, String categoryImage){
       Category category = new Category(categoryName, categoryImage);
      return categoryRepository.save(category);
   }
    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }
}
