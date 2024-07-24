package com.asif.cc_summer.service;

import com.asif.cc_summer.dto.response.CartListResponse;
import com.asif.cc_summer.entity.Cart;
import com.asif.cc_summer.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;

    public Cart save(Cart order) {
        return cartRepository.save(order);
    }
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    public List<CartListResponse> cartListResponse(Integer user_id) {
        List<Cart> allData = cartRepository.findAll();
        //List<Cart> filteredData = allData.stream()
            //    .filter(p -> p.getUser_id() == user_id).toList();
        List<Cart> cartListFilter = new ArrayList<>();
        for(int i = 0; i< allData.size(); i++){
            Cart cart = allData.get(i);
            if(cart.getUser_id().equals(user_id)){
                cartListFilter.add(cart);
            }

        }
        List<CartListResponse> cartListResponse = new ArrayList<>();

        for(int i = 0; i< cartListFilter.size(); i++){
            Cart cart = cartListFilter.get(i);

            CartListResponse responseItem = new CartListResponse();
            responseItem.product_id = cart.getProduct_id();
            responseItem.quantity = cart.getQuantity();
            responseItem.image="FanOne";
            responseItem.price=200;
            responseItem.name="Fan";


            cartListResponse.add(responseItem);

        }

        return cartListResponse;
    }
}
