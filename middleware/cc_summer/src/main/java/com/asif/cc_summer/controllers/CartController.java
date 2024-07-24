package com.asif.cc_summer.controllers;

import com.asif.cc_summer.entity.Cart;
import com.asif.cc_summer.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        Cart response = cartService.save(orderedProduct);
        return ResponseEntity.ok("Added to cart");


    }
    @PostMapping(value="/cartList", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> cartList(@RequestParam Integer user_id){
        List<Cart> list= cartService.findAll();
        return ResponseEntity.ok("Added Cart List");
    }
    @GetMapping(value = "/getCartList", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCartCategory() {
        List<Cart> list= cartService.findAll();
        return ResponseEntity.ok(list);
    }


}
