package com.asif.cc_summer.controllers;

import com.asif.cc_summer.dto.response.BaseResponseDto;
import com.asif.cc_summer.dto.response.CartListResponse;
import com.asif.cc_summer.entity.Cart;
import com.asif.cc_summer.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/cart")
public class CartController {
    private final CartService cartService;

    @PostMapping(value ="/addToCart", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addToCart(@RequestParam Integer user_id,
                                         @RequestParam Integer product_id, @RequestParam Integer quantity) {
        Cart orderedProduct = new Cart();
        orderedProduct.setUser_id(user_id);
        orderedProduct.setProduct_id(product_id);
        orderedProduct.setQuantity(quantity);
        Cart cardResponse = cartService.save(orderedProduct);

        BaseResponseDto response = new BaseResponseDto();
        response.statusCode = 200;
        response.success_message = "Added to cart";
        response.data = cardResponse;
        return ResponseEntity.ok(response);

    }
    @PostMapping(value="/cartList", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> cartList(@RequestParam Integer user_id){
        List<CartListResponse> list = cartService.cartListResponse(user_id);

        BaseResponseDto response = new BaseResponseDto();
        response.statusCode = 200;
        response.data = list;
        return ResponseEntity.ok(response);
    }

}
