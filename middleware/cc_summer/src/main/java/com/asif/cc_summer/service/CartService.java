package com.asif.cc_summer.service;

import com.asif.cc_summer.dto.response.CartListResponse;
import com.asif.cc_summer.entity.Cart;
import com.asif.cc_summer.entity.Product;
import com.asif.cc_summer.repository.CartRepository;
import com.asif.cc_summer.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public Cart save(Cart order) {
        return cartRepository.save(order);
    }

    public Cart increaseQuantity( Long cartID,  Integer quantity) {
        Optional<Cart> cart = cartRepository.findById(cartID);
        if(cart.isPresent()) {
            Cart updatedCart = cart.get();
            updatedCart.setQuantity(quantity);
            return cartRepository.save(updatedCart);
        }
        //update object by repository
        return cartRepository.save(cart.get());
    }
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    public List<CartListResponse> cartListResponse(Long user_id) {
        List<Cart> allData = cartRepository.findAll();
        List<Cart> cartListFilter = new ArrayList<>();
        for (Cart cart : allData) {
            if (cart.getUser_id().equals(user_id) && !cart.getOrdered()) {
                cartListFilter.add(cart);
            }
        }
        List<CartListResponse> cartListResponse = new ArrayList<>();

        for (Cart cart : cartListFilter) {
            Long productId = cart.getProduct_id();
            Optional<Product> product = productRepository.findById(productId);

            CartListResponse responseItem = new CartListResponse();
            responseItem.id = cart.getId();
            responseItem.product_id = cart.getProduct_id();
            responseItem.quantity = cart.getQuantity();
            if(product.isPresent()) {
                responseItem.image = product.get().getImage();
                responseItem.price = product.get().getPrice();
                responseItem.name = product.get().getName();
            }
            cartListResponse.add(responseItem);
        }

        return cartListResponse;
    }

    public Optional<CartListResponse> cartResponseByID(Long cartID) {
        Optional<Cart> optionalCart = cartRepository.findById(cartID);

        if (optionalCart.isPresent()) {
            Cart cart = optionalCart.get();

            Long productId = cart.getProduct_id();
            Optional<Product> product = productRepository.findById(productId);

            CartListResponse responseItem = new CartListResponse();
            responseItem.id = cart.getId();
            responseItem.product_id = cart.getProduct_id();
            responseItem.quantity = cart.getQuantity();
            if(product.isPresent()) {
                responseItem.image = product.get().getImage();
                responseItem.price = product.get().getPrice();
                responseItem.name = product.get().getName();
            }
            return Optional.of(responseItem);
        }

        return Optional.empty();
    }
}
