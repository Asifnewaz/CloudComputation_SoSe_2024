package com.asif.cc_summer.service;

import com.asif.cc_summer.entity.ProductCategory;
import com.asif.cc_summer.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;


   public ProductCategory addService(String categoryName, String categoryImage){
       ProductCategory category = new ProductCategory();
       category.setCategoryName(categoryName);
       category.setImage(categoryImage);
      return categoryRepository.save(category);
   }
    public List<ProductCategory> getAllCategory(){
        return categoryRepository.findAll();
    }
}
