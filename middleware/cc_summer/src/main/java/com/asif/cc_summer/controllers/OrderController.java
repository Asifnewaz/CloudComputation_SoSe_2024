package com.asif.cc_summer.controllers;

import com.asif.cc_summer.entity.OrderedProduct;
import com.asif.cc_summer.entity.ProductCategory;
import com.asif.cc_summer.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping(value ="/addToCart", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addToCart(@RequestParam Integer userID,
                                         @RequestParam Integer productID) {
        OrderedProduct orderedProduct = new OrderedProduct();
        orderedProduct.setProductID(productID);
        orderedProduct.setUserID(userID);
        OrderedProduct response = orderService.save(orderedProduct);
        return ResponseEntity.ok("Added to cart");
    }


}
