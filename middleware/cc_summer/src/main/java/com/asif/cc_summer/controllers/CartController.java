package com.asif.cc_summer.controllers;

import com.asif.cc_summer.entity.Cart;
import com.asif.cc_summer.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/order")
public class CartController {
    private final OrderService orderService;

    @PostMapping(value ="/addToCart", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addToCart(@RequestParam Integer userID,
                                         @RequestParam Integer productID) {
        Cart orderedProduct = new Cart();
        orderedProduct.setProductID(productID);
        orderedProduct.setUserID(userID);
        Cart response = orderService.save(orderedProduct);
        return ResponseEntity.ok("Added to cart");


    }
    @GetMapping(value = "/getOrderList", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getOrderCategory() {
        List<Cart> list= orderService.findAll();
        return ResponseEntity.ok(list);
    }


}
