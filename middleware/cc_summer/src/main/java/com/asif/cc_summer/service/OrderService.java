package com.asif.cc_summer.service;

import com.asif.cc_summer.dto.response.CartListResponse;
import com.asif.cc_summer.entity.Cart;
import com.asif.cc_summer.entity.OrderEntity;
import com.asif.cc_summer.entity.Product;
import com.asif.cc_summer.entity.ProductCategory;
import com.asif.cc_summer.repository.CartRepository;
import com.asif.cc_summer.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    public final OrderRepository orderRepository;
    private final CartRepository cartRepository;

    public OrderEntity addService(Long userid,
                                   String name,
                                   String mobile,
                                   String email,
                                   String address) {
        // creating entity for repository
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setUserId(userid);
        orderEntity.setName(name);
        orderEntity.setAddress(address);
        orderEntity.setPhone(mobile);
        orderEntity.setEmail(email);

        //update cart ordered status
        updateOldCardAfterAnOrder(userid);

        return orderRepository.save(orderEntity);
    }

    private void updateOldCardAfterAnOrder(Long userid) {
        List<Cart> allData = cartRepository.findAll();
        List<Cart> cartListFilter = new ArrayList<>();
        for (Cart cart : allData) {
            if (cart.getUser_id().equals(userid)) {
                cartListFilter.add(cart);
            }
        }

        for (Cart cart : cartListFilter) {
            cart.setOrdered(true);
            cartRepository.save(cart);
        }
    }
}
