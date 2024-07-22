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
       // creating entity for repository
       ProductCategory category = new ProductCategory();

       //setting category name into entity
       category.setCategoryName(categoryName);

       //setting image name into entity
       category.setImage(categoryImage);

       // saving entity into database
      return categoryRepository.save(category);
   }
    public List<ProductCategory> getAllCategory(){
        return categoryRepository.findAll();
    }
}
