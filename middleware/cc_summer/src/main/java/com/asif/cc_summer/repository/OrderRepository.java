package com.asif.cc_summer.repository;

import com.asif.cc_summer.entity.OrderedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderedProduct, Long>  {
}
