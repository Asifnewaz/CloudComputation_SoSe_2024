package com.asif.cc_summer.repository;

import com.asif.cc_summer.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
