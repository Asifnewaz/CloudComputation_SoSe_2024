package com.asif.cc_summer.service;

import com.asif.cc_summer.entity.Cart;
import com.asif.cc_summer.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Cart save(Cart order) {
        return orderRepository.save(order);
    }
    public List<Cart> findAll() {
        return orderRepository.findAll();
    }
}
