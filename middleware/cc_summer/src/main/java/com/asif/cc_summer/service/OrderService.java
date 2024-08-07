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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        LocalDate currentDate = LocalDate.now();
        // Format the date as a string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);
        orderEntity.setDateTime(formattedDate);
        orderEntity.setOrderStatus("new");
        orderEntity.setPaymentDone(false);

        //update cart ordered status
        updateOldCardAfterAnOrder(userid);

        List<Cart> cartListFilter = getUnOrderedCartList(userid);
        if (!cartListFilter.isEmpty()) {
            StringBuilder cartIDs = new StringBuilder();
            for (Cart cart : cartListFilter) {
                Long cartId = cart.getId();
                cartIDs.append(cartId).append(",");
            }
            orderEntity.setCartIDs(cartIDs.toString());
        }
        return orderRepository.save(orderEntity);

    }
    public Optional<OrderEntity> orderPaymentDone(Long orderID) {
        Optional<OrderEntity> order = orderRepository.findById(orderID);
        if (order.isPresent()) {
            OrderEntity orderEntity = order.get();
            orderEntity.setPaymentDone(true);
            orderEntity.setOrderStatus("processing");
            orderRepository.save(orderEntity);
            return Optional.of(orderEntity);
        }
        return order;
    }

    public List<OrderEntity> getOrders(Long userid) {
        List<OrderEntity> allOrders = orderRepository.findAll();
        List<OrderEntity> filteredOrders = new ArrayList<>();

        for (OrderEntity orderEntity : allOrders) {
            if (orderEntity.getUserId().equals(userid)) {
                filteredOrders.add(orderEntity);
            }
        }
        return filteredOrders;
    }

    private List<Cart> getUnOrderedCartList(Long userid) {
        List<Cart> allData = cartRepository.findAll();
        List<Cart> cartListFilter = new ArrayList<>();
        for (Cart cart : allData) {
            if (cart.getUser_id().equals(userid)) {
                cartListFilter.add(cart);
            }
        }
        return cartListFilter;
    }

    private void updateOldCardAfterAnOrder(Long userid) {
        List<Cart> cartListFilter = getUnOrderedCartList(userid);

        for (Cart cart : cartListFilter) {
            cart.setOrdered(true);
            cartRepository.save(cart);
        }
    }
}
