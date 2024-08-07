package com.asif.cc_summer.controllers;

import com.asif.cc_summer.dto.request.ProductDto;
import com.asif.cc_summer.dto.response.BaseResponseDto;
import com.asif.cc_summer.dto.response.CartListResponse;
import com.asif.cc_summer.dto.response.OrderDetailsResponse;
import com.asif.cc_summer.entity.OrderEntity;
import com.asif.cc_summer.entity.Product;
import com.asif.cc_summer.entity.ProductCategory;
import com.asif.cc_summer.entity.UserEntity;
import com.asif.cc_summer.service.CartService;
import com.asif.cc_summer.service.OrderService;
import com.asif.cc_summer.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/order")
public class OrderController {

    private final OrderService orderService;
    private final CartService cartService;

    @PostMapping(value = "/makeOrder", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> makeOrder(@RequestParam Long userid,
                                       @RequestParam String name,
                                       @RequestParam String mobile_number,
                                       @RequestParam String email_address,
                                       @RequestParam String address) {
        OrderEntity entity = orderService.addOrder(userid, name, mobile_number, email_address, address);
        BaseResponseDto response = new BaseResponseDto();
        response.statusCode = 200;
        response.success_message = "Order added successfully";
        response.data = entity;
        return ResponseEntity.ok(response);
    }

    @PostMapping(value ="/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getOrders(@RequestParam Long userid) {
        List<OrderEntity> list = orderService.getOrders(userid);

        BaseResponseDto response = new BaseResponseDto();
        response.statusCode = 200;
        response.success_message = "";
        response.data = list;
        return ResponseEntity.ok(response);
    }

    @PostMapping(value ="/updatePayment", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updatePayment(@RequestParam Long orderID) {
        Optional<OrderEntity> order = orderService.orderPaymentDone(orderID);

        BaseResponseDto response = new BaseResponseDto();
        response.statusCode = 200;
        response.success_message = "";
        order.ifPresent(orderEntity -> response.data = orderEntity);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value ="/getDetailsOrder", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getDetailsOrder(@RequestParam Long orderID) {
        Optional<OrderEntity> orderEntity = orderService.getOrder(orderID);

        OrderDetailsResponse orderDetailsResponse = new OrderDetailsResponse();
        if (orderEntity.isPresent()) {
            OrderEntity order = orderEntity.get();
            orderDetailsResponse.setId(order.getId());
            orderDetailsResponse.setUserId(order.getUserId());
            orderDetailsResponse.setName(order.getName());
            orderDetailsResponse.setAddress(order.getAddress());
            orderDetailsResponse.setPhone(order.getPhone());
            orderDetailsResponse.setEmail(order.getEmail());
            orderDetailsResponse.setOrderStatus(order.getOrderStatus());
            orderDetailsResponse.setPaymentDone(order.getPaymentDone());
            orderDetailsResponse.setDateTime(order.getDateTime());
            orderDetailsResponse.setStatus(order.getStatus());

            List<CartListResponse> cartListResponses = new ArrayList<>();

            String cartIDs = order.getCartIDs();
            //split string by .
            // Split the string by the "." character
            String[] parts = cartIDs.split(",");

            // Convert each part to a Long and print the results
            for (String part : parts) {
                try {
                    Long value = Long.parseLong(part);
                    Optional<CartListResponse> cartListResponse = cartService.cartResponseByID(value);
                    if (cartListResponse.isPresent()) {
                        CartListResponse cartList = cartListResponse.get();
                        cartListResponses.add(cartList);
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Error converting part to Long: " + part);
                }
            }

            orderDetailsResponse.setCartList(cartListResponses);
        }

        BaseResponseDto response = new BaseResponseDto();
        response.statusCode = 200;
        response.success_message = "";
        response.data = orderDetailsResponse;
        return ResponseEntity.ok(response);
    }
}
