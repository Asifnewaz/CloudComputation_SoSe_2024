package com.asif.cc_summer.service;

import com.asif.cc_summer.entity.OrderedProduct;
import com.asif.cc_summer.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderedProduct save(OrderedProduct order) {
        return orderRepository.save(order);
    }
}
