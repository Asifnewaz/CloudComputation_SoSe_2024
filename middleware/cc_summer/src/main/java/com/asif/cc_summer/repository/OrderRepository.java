package com.asif.cc_summer.repository;

import com.asif.cc_summer.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Cart, Long>  {
}
