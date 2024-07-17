package com.asif.cc_summer.repository;

import com.asif.cc_summer.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
